#include <sys/types.h>
#include <wait.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>
#include <signal.h>

//Constantes
#define SIZE 512

//Funciones prototipo
void codigo_hijo(void);
void codigo_padre(pid_t);
void manejador(int signum);

// Variables globales
int tP2H[2]; // Tubería para enviar mensajes desde el Padre al Hijo.
int tH2P[2]; // Tubería para enviar mensajes desde el Hijo al Padre.
char mensaje[SIZE]; // Buffer para almacenar los mensajes enviados/recibidos.

int main(void)
{
}

void codigo_hijo()
{
}

void codigo_padre(pid_t pid)
{
}

void manejador (int signum)
{
}