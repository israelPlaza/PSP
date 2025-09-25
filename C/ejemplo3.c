#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>
int main()
{
pid_t pid;
printf("PADRE: Soy el proceso padre y mi pid es: %d\n", getpid());
pid = fork();
if (pid>0) // Este es el proceso padre
{
printf("PADRE: Soy el proceso padre y mi pid sigue siendo: %d\n", getpid());
printf("PADRE: Mi hijo tiene el pid: %d\n", pid);
}
else // Proceso hijo ¡Ojo, si es -1 es un error!
{
printf("HIJO: Soy el proceso hijo y mi pid es: %d\n", getpid());
printf("HIJO: mi padre tiene el pid: %d\n", getppid());
}
}

