#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
int main() {
char expresion[] = "23 + 47";
int operando1, operando2;
char operador;
// Usamos sscanf para extraer los elementos
if (sscanf(expresion, "%d %c %d", &operando1, &operador,
&operando2) == 3) {
printf("Operando 1: %d\n", operando1);
printf("Operador: %c\n", operador);
printf("Operando 2: %d\n", operando2);
} else {
printf("Error al analizar la expresión.\n");
}
return 0;
}