#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>

#define MAX_NUM 1000

int main() {
    int p1[2], p2[2];  // p1: padre escribe, hijo lee; p2: hijo escribe, padre lee
    pid_t pid;
    int numero_secreto, intento, num_intentos = 0;
    char buffer[50];

    // Crear tuberías
    if (pipe(p1) == -1 || pipe(p2) == -1) {
        perror("Error al crear la tubería");
        exit(EXIT_FAILURE);
    }

    // Crear el proceso hijo
    if ((pid = fork()) == -1) {
        perror("Error al hacer fork");
        exit(EXIT_FAILURE);
    }

    if (pid == 0) {  // Código del proceso hijo
        close(p1[1]);  // Cerrar el lado de escritura del padre en la tubería 1
        close(p2[0]);  // Cerrar el lado de lectura del padre en la tubería 2

        while (1) {
            // Generar un número aleatorio entre 0 y 1000
            intento = rand() % (MAX_NUM + 1);  // Aquí no se utiliza srand()

            // Enviar el número al padre
            sprintf(buffer, "%d", intento);
            write(p2[1], buffer, strlen(buffer) + 1);  // Enviar el intento

            // Esperar el resultado del padre
            read(p1[0], buffer, sizeof(buffer));

            if (strcmp(buffer, "correcto") == 0) {
                // Si es correcto, salir del bucle
                printf("Hijo: He adivinado el número correctamente!\n");
                break;
            } else {
                // Mostrar la pista (mayor o menor)
                printf("Hijo: El número %d es %s.\n", intento, buffer);
            }
        }

        close(p1[0]);  // Cerrar el lado de lectura del hijo en la tubería 1
        close(p2[1]);  // Cerrar el lado de escritura del hijo en la tubería 2
        exit(0);

    } else {  // Código del proceso padre
        close(p1[0]);  // Cerrar el lado de lectura del padre en la tubería 1
        close(p2[1]);  // Cerrar el lado de escritura del hijo en la tubería 2

        // Generar el número secreto entre 0 y 1000
        numero_secreto = rand() % (MAX_NUM + 1);  // Aquí no se utiliza srand()
        printf("Padre: El número secreto es %d.\n", numero_secreto);

        while (1) {
            // Leer el intento del hijo
            read(p2[0], buffer, sizeof(buffer));
            intento = atoi(buffer);  // Convertir el intento a entero
            num_intentos++;

            if (intento == numero_secreto) {
                // Si el número es correcto, enviar "correcto"
                strcpy(buffer, "correcto");
                write(p1[1], buffer, strlen(buffer) + 1);
                printf("Padre: El hijo ha acertado en %d intentos!\n", num_intentos);
                break;
            } else if (intento < numero_secreto) {
                // Si el número es menor, enviar "mayor"
                strcpy(buffer, "mayor");
            } else {
                // Si el número es mayor, enviar "menor"
                strcpy(buffer, "menor");
            }
            write(p1[1], buffer, strlen(buffer) + 1);  // Enviar pista al hijo
        }

        close(p1[1]);  // Cerrar el lado de escritura del padre en la tubería 1
        close(p2[0]);  // Cerrar el lado de lectura del padre en la tubería 2

        // Esperar a que el hijo termine
        wait(NULL);
    }

    return 0;
}
