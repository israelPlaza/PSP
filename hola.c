#include <stdio.h>
#include <unistd.h>

int main (){

    printf (“Ejemplo de uso de execl\n”);
    printf (“Esta carpeta contiene:\n”);
    execl(“/bin/ls”, “ls”, “-l”,(char *) NULL);
    printf (“Esto no llega a ejecutarse nunca\n”);
return 0;
}
