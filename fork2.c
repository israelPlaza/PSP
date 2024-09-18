#include <stdio.h>
#include <unistd.h>
int  main()
{
    fork();
    fork();
    printf("hola mundo\n");

    return 0;
}
