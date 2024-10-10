#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main() {
    pid_t pid;
    int resultado;
    pid = fork();

    switch (pid) {
    case -1:
        printf("No se ha podido crear el proceso hijo...\n");
        exit(-1);
    case 0:
        // Proceso hijo
        // printf("HIJO: Mi PID es %d y el de padre %d\n", getpid(), getppid());
        sleep(5);
        exit(8);
    default:
        // Proceso padre
        printf("PADRE: Mi PID es %d y el de hijo %d\n", getpid(), pid);
        pid = waitpid(pid, &resultado, 0);
        printf("PADRE: El proceso con PID %d ha finalizado\n", pid);
        if (WIFEXITED(resultado)) {
            printf("Resultado: %d\n", WEXITSTATUS(resultado));
        }
    }
    exit(0);
}
