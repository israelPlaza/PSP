#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
void main()
{
    pid_t pid;
    pid = fork();
if (pid == -1 ) //Ha ocurrido un error
{
printf("No se ha podido crear el proceso hijo...");
exit(-1);
}
else
{
if (pid==0) // Proceso hijo
{
printf (“soy el proceso hijo y mi PID es %d”,getpid());
printf (“y el de mi padre %d\n”,getppid());
}
else //Nos encontramos en Proceso padre
{
pid = wait(NULL); //espera la finalización del proceso hijo
printf("Soy el proceso padre con pid %d\n”,getpid());
printf (“Mi hijo con pid: %d terminó.\n", pid);
}
exit(0);
}