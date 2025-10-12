#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>
#include <sys/wait.h>

#define NUM_INTENTOS 5

// Estructura para almacenar resultados
typedef struct {
    int intento;
    char expresion[20];
    int resultado_hijo1;
    char veredicto[15];
    int resultado_hijo2;
} Resultado;

// Función para calcular el resultado de una expresión
int calcular(int op1, char operador, int op2) {
    switch(operador) {
        case '+': return op1 + op2;
        case '-': return op1 - op2;
        case '*': return op1 * op2;
        case '/': return (op2 != 0) ? op1 / op2 : 0;
        default: return 0;
        
    }
}

int main() {
    int pipe_padre_hijo1[2], pipe_hijo1_padre[2];
    int pipe_padre_hijo2[2], pipe_hijo2_padre[2];
    pid_t pid_hijo1, pid_hijo2;
    Resultado resultados[NUM_INTENTOS];
    
    srand(time(NULL));
    
    // Crear pipes
    if (pipe(pipe_padre_hijo1) == -1 || pipe(pipe_hijo1_padre) == -1 ||
        pipe(pipe_padre_hijo2) == -1 || pipe(pipe_hijo2_padre) == -1) {
        perror("Error al crear pipes");
        exit(1);
    }
    
    // Crear primer hijo
    pid_hijo1 = fork();
    
    if (pid_hijo1 == -1) {
        perror("Error al crear hijo1");
        exit(1);
    }
    
    if (pid_hijo1 == 0) {
        // PROCESO HIJO 1: Calcula las operaciones
        close(pipe_padre_hijo1[1]); // Cerrar escritura
        close(pipe_hijo1_padre[0]); // Cerrar lectura
        close(pipe_padre_hijo2[0]); // No usa estos pipes
        close(pipe_padre_hijo2[1]);
        close(pipe_hijo2_padre[0]);
        close(pipe_hijo2_padre[1]);
        
        for (int i = 0; i < NUM_INTENTOS; i++) {
            char expresion[20];
            int operando1, operando2, resultado;
            char operador;
            
            // Leer expresión del padre
            read(pipe_padre_hijo1[0], expresion, sizeof(expresion));
            
            // Extraer elementos de la expresión
            sscanf(expresion, "%d %c %d", &operando1, &operador, &operando2);
            
            // Calcular resultado
            resultado = calcular(operando1, operador, operando2);
            
            // Introducir error aleatorio (10% de probabilidad)
            if (rand() % 10 == 0) {
                resultado += (rand() % 10 + 1); // Añadir error
            }
            
            // Enviar resultado al padre
            write(pipe_hijo1_padre[1], &resultado, sizeof(int));
        }
        
        close(pipe_padre_hijo1[0]);
        close(pipe_hijo1_padre[1]);
        exit(0);
    }
    
    // Crear segundo hijo
    pid_hijo2 = fork();
    
    if (pid_hijo2 == -1) {
        perror("Error al crear hijo2");
        exit(1);
    }
    
    if (pid_hijo2 == 0) {
        // PROCESO HIJO 2: Verifica los resultados
        close(pipe_padre_hijo2[1]); // Cerrar escritura
        close(pipe_hijo2_padre[0]); // Cerrar lectura
        close(pipe_padre_hijo1[0]); // No usa estos pipes
        close(pipe_padre_hijo1[1]);
        close(pipe_hijo1_padre[0]);
        close(pipe_hijo1_padre[1]);
        
        for (int i = 0; i < NUM_INTENTOS; i++) {
            char buffer[50];
            int operando1, operando2, resultado_recibido, resultado_correcto;
            char operador;
            
            // Leer expresión y resultado del padre
            read(pipe_padre_hijo2[0], buffer, sizeof(buffer));
            
            // Formato: "operando1 operador operando2 resultado"
            sscanf(buffer, "%d %c %d %d", &operando1, &operador, &operando2, &resultado_recibido);
            
            // Calcular el resultado correcto
            resultado_correcto = calcular(operando1, operador, operando2);
            
            // Verificar si es correcto
            int es_correcto = (resultado_recibido == resultado_correcto);
            
            // Enviar veredicto y resultado correcto al padre
            char respuesta[50];
            sprintf(respuesta, "%d %d", es_correcto, resultado_correcto);
            write(pipe_hijo2_padre[1], respuesta, sizeof(respuesta));
        }
        
        close(pipe_padre_hijo2[0]);
        close(pipe_hijo2_padre[1]);
        exit(0);
    }
    
    // PROCESO PADRE
    close(pipe_padre_hijo1[0]); // Cerrar lectura
    close(pipe_hijo1_padre[1]); // Cerrar escritura
    close(pipe_padre_hijo2[0]); // Cerrar lectura
    close(pipe_hijo2_padre[1]); // Cerrar escritura
    
    printf("\n=== SISTEMA DE COMPUTADORAS NASA ===\n");
    printf("Iniciando %d operaciones matemáticas...\n\n", NUM_INTENTOS);
    
    int aciertos = 0, errores = 0;
    
    for (int i = 0; i < NUM_INTENTOS; i++) {
        int operando1 = rand() % 100 + 1;
        int operando2 = rand() % 100 + 1;
        char operadores[] = {'+', '-', '*', '/'};
        char operador = operadores[rand() % 4];
        
        char expresion[20];
        sprintf(expresion, "%d %c %d", operando1, operador, operando2);
        
        // Enviar expresión al hijo 1
        write(pipe_padre_hijo1[1], expresion, sizeof(expresion));
        
        // Recibir resultado del hijo 1
        int resultado_hijo1;
        read(pipe_hijo1_padre[0], &resultado_hijo1, sizeof(int));
        
        // Enviar expresión y resultado al hijo 2 para verificación
        char mensaje_hijo2[50];
        sprintf(mensaje_hijo2, "%d %c %d %d", operando1, operador, operando2, resultado_hijo1);
        write(pipe_padre_hijo2[1], mensaje_hijo2, sizeof(mensaje_hijo2));
        
        // Recibir veredicto del hijo 2
        char respuesta_hijo2[50];
        read(pipe_hijo2_padre[0], respuesta_hijo2, sizeof(respuesta_hijo2));
        
        int es_correcto, resultado_hijo2;
        sscanf(respuesta_hijo2, "%d %d", &es_correcto, &resultado_hijo2);
        
        // Guardar resultado
        resultados[i].intento = i + 1;
        strcpy(resultados[i].expresion, expresion);
        resultados[i].resultado_hijo1 = resultado_hijo1;
        strcpy(resultados[i].veredicto, es_correcto ? "CORRECTO" : "INCORRECTO");
        resultados[i].resultado_hijo2 = resultado_hijo2;
        
        if (es_correcto) {
            aciertos++;
        } else {
            errores++;
        }
    }
    
    // Cerrar pipes
    close(pipe_padre_hijo1[1]);
    close(pipe_hijo1_padre[0]);
    close(pipe_padre_hijo2[1]);
    close(pipe_hijo2_padre[0]);
    
    // Esperar a que terminen los hijos
    wait(NULL);
    wait(NULL);
    
    // Mostrar tabla de resultados
    printf("\n=== TABLA DE RESULTADOS ===\n");
    printf("%-10s %-20s %-15s %-15s %-15s\n", 
           "Intento", "Expresión", "Resultado H1", "Veredicto", "Resultado H2");
    printf("------------------------------------------------------------------------\n");
    
    for (int i = 0; i < NUM_INTENTOS; i++) {
        printf("%-10d %-20s %-15d %-15s %-15d\n",
               resultados[i].intento,
               resultados[i].expresion,
               resultados[i].resultado_hijo1,
               resultados[i].veredicto,
               resultados[i].resultado_hijo2);
    }
    
    printf("------------------------------------------------------------------------\n");
    printf("\n=== ESTADÍSTICAS ===\n");
    printf("Total de operaciones: %d\n", NUM_INTENTOS);
    printf("Aciertos: %d (%.1f%%)\n", aciertos, (aciertos * 100.0) / NUM_INTENTOS);
    printf("Errores: %d (%.1f%%)\n", errores, (errores * 100.0) / NUM_INTENTOS);
    printf("\n");
    
    return 0;
}