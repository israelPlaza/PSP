#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <time.h>
#include <sys/types.h>
#include <sys/wait.h>

// Defino unas constantes para que sea mas facil cambiar cosas luego
#define NUM_INTENTOS 10
#define SIZE 512
#define PROBABILIDAD_ERROR 20 // Probabilidad de que el hijo 1 se equivoque

// Pongo aqui las cabeceras de las funciones que usare mas abajo
void generar_expresion(char *expresion);
double calcular_expresion(const char *expresion);

int main() {
    // Para que los numeros aleatorios no sean siempre los mismos
    srand(time(NULL));

    // Tuberias para hablar con el primer hijo
    int padre_a_h1[2], h1_a_padre[2];
    // Tuberias para hablar con el segundo hijo
    int padre_a_h2[2], h2_a_padre[2];

    // Creo todas las tuberias y compruebo si ha habido algun error
    if (pipe(padre_a_h1) == -1 || pipe(h1_a_padre) == -1 || 
        pipe(padre_a_h2) == -1 || pipe(h2_a_padre) == -1) {
        perror("Error creando las tuberías");
        exit(EXIT_FAILURE);
    }

    // Creamos el primer hijo
    pid_t pid1 = fork();
    if (pid1 == -1) {
        perror("Error al crear el primer hijo");
        exit(EXIT_FAILURE);
    }
    
    if (pid1 == 0) {
      

        // El hijo 1 solo lee del padre, asi que cierro la escritura de ese pipe.
        close(padre_a_h1[1]); 
        // Y por el otro pipe solo escribe, asi que cierro la lectura.
        close(h1_a_padre[0]); 
        
        // Cierro todos los pipes del otro hijo, porque este no los toca para nada
        close(padre_a_h2[0]); close(padre_a_h2[1]);
        close(h2_a_padre[0]); close(h2_a_padre[1]);

        char buffer[SIZE];
        
        // Se queda aqui esperando a que el padre le mande operaciones
        while (read(padre_a_h1[0], buffer, SIZE) > 0) {
            double resultado = calcular_expresion(buffer);

            // Para que falle de forma aleatoria
            if ((rand() % 100) < PROBABILIDAD_ERROR) {
                resultado += (rand() % 10 + 1) - 5; 
            }

            char respuesta[SIZE];
            sprintf(respuesta, "%.2f", resultado);
            write(h1_a_padre[1], respuesta, strlen(respuesta) + 1);
        }

        
        close(padre_a_h1[0]);
        close(h1_a_padre[1]);
        exit(EXIT_SUCCESS);
    }

    // Creamos el segundo hijo
    pid_t pid2 = fork();
    if (pid2 == -1) {
        perror("Error al crear el segundo hijo");
        exit(EXIT_FAILURE);
    }
    
    if (pid2 == 0) {
        
        //cierro los extremos de los pipes
        close(padre_a_h2[1]); 
        close(h2_a_padre[0]); 

        close(padre_a_h1[0]); close(padre_a_h1[1]);
        close(h1_a_padre[0]); close(h1_a_padre[1]);

        char buffer[SIZE];
        
        // Bucle principal del hijo 2, esperando datos del padre
        while (read(padre_a_h2[0], buffer, SIZE) > 0) {
            char expresion[SIZE];
            double resultado_h1;
          
            sscanf(buffer, "%[^;];%lf", expresion, &resultado_h1);
            double resultado_correcto = calcular_expresion(expresion);
            
            char veredicto[SIZE];
            
            if (resultado_h1 == resultado_correcto) {
                sprintf(veredicto, "CORRECTO;%.2f", resultado_correcto);
            } else {
                sprintf(veredicto, "INCORRECTO;%.2f", resultado_correcto);
            }
            
            // Le mando el veredicto de vuelta al padre
            write(h2_a_padre[1], veredicto, strlen(veredicto) + 1);
        }

        close(padre_a_h2[0]);
        close(h2_a_padre[1]);
        exit(EXIT_SUCCESS);
    }

    //cerramos  los extremos
    close(padre_a_h1[0]); 
    close(h1_a_padre[1]); 
    close(padre_a_h2[0]); 
    close(h2_a_padre[1]); 

    printf("\n=== SISTEMA DE COMPUTADORAS NASA ===\n");
    printf("Iniciando %d operaciones matematicas...\n\n", NUM_INTENTOS);
    printf("%-10s %-20s %-20s %-15s %-20s\n", "Intento", "Expresion", "Resultado Hijo1", "Veredicto", "Resultado Hijo2");
    printf("-----------------------------------------------------------------------------------------------\n");

    int aciertos = 0;

    // Bucle de intentos
    for (int i = 1; i <= NUM_INTENTOS; i++) {
        char expresion[SIZE];
        generar_expresion(expresion);

        // Mando la operacion al primer hijo
        write(padre_a_h1[1], expresion, strlen(expresion) + 1);
        char resultado_h1_str[SIZE];
        read(h1_a_padre[0], resultado_h1_str, SIZE);
        double resultado_h1 = atof(resultado_h1_str);

        // verifique el 2 hijo
        char mensaje_h2[SIZE];
        sprintf(mensaje_h2, "%s;%.2f", expresion, resultado_h1);
        write(padre_a_h2[1], mensaje_h2, strlen(mensaje_h2) + 1);
        char veredicto[SIZE];
        read(h2_a_padre[0], veredicto, SIZE);
        
        // 
        char estado[20];
        double resultado_h2;
        sscanf(veredicto, "%[^;];%lf", estado, &resultado_h2);

        if (strcmp(estado, "CORRECTO") == 0) {
            aciertos++;
        }

        // Imprimo  intento
        printf("%-10d %-20s %-20.2f %-15s %-20.2f\n", i, expresion, resultado_h1, estado, resultado_h2);
    }

    // Cierro los pipes
    close(padre_a_h1[1]);
    close(padre_a_h2[1]);

    // Espero a que los dos hijos acaben para que no se queden zombies
    wait(NULL);
    wait(NULL);

    printf("-----------------------------------------------------------------------------------------------\n");
    printf("\n=== ESTADISTICAS FINALES ===\n");
    printf("Total de operaciones: %d\n", NUM_INTENTOS);
    printf("Aciertos: %d (%.1f%%)\n", aciertos, (aciertos * 100.0) / NUM_INTENTOS);
    printf("Errores: %d (%.1f%%)\n", NUM_INTENTOS - aciertos, ((NUM_INTENTOS - aciertos) * 100.0) / NUM_INTENTOS);
    printf("\n");

    return 0;
}
// Funcion para crear una operacion aleatoria
void generar_expresion(char *expresion) {
    int a = rand() % 100 + 1;
    int b = rand() % 100 + 1;
    char operadores[] = {'+', '-', '*', '/'};
    char op = operadores[rand() % 4];

    if (op == '/' && b != 0) {
       a = (rand() % 10 + 1) * b;
    }

    sprintf(expresion, "%d %c %d", a, op, b);
}

// Funcion que calcula el resultado de una operacion en formato texto
double calcular_expresion(const char *expresion) {
    int a, b;
    char op;
    double resultado = 0.0;

    
    if (sscanf(expresion, "%d %c %d", &a, &op, &b) == 3) {
        switch (op) {
            case '+': resultado = a + b; break;
            case '-': resultado = a - b; break;
            case '*': resultado = a * b; break;
            case '/': 
                if (b != 0) resultado = (double)a / b;
                break;
        }
    }
    return resultado;
}

