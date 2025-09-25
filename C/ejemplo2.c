#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main(void)
{
pid_t pid = fork();
// instrucciones que tanto el padre como el hijo harán
if (pid > 0)
{
// instrucciones que solo el proceso padre hará
}
else
{
// instrucciones que solo el proceso hijo hará. ¡Ojo -1 es error!
}
}
