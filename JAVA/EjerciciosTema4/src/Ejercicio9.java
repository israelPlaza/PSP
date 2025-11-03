import java.util.Scanner;

public class Ejercicio9 {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        int contador = 0;
        long suma = 0;
        double media;
        int maximo = Integer.MIN_VALUE;
        int minimo = Integer.MAX_VALUE;
        boolean esPrimo; // Bandera para comprobar si es primo

        System.out.println("Introduce números enteros positivos.");
        System.out.println("El programa parará cuando introduzcas un número primo.");

        // --- 2. Bucle principal ---
        while (true) {
            
                System.out.print("Introduce un número: ");
                numero = scanner.nextInt();
                
                // 2.1. Validar que sea positivo
                if (numero <= 0) {
                    System.out.println("Error: El número debe ser positivo.");
                    continue; 
                }
                
                esPrimo = true; 
                
                if (numero <= 1) { 
                    esPrimo = false;
                } else {
                   
                    for (int i = 2; i < numero; i++) {
                        if (numero % i == 0) {
                            
                            esPrimo = false; 
                            
                        }
                    }
                }
                
                if (esPrimo) {
                    System.out.println("\n¡Número primo detectado (" + numero + ")!");
                    System.out.println("Terminando el programa...");
                    break; // Rompe el bucle while
                }

                contador++;
                suma += numero;

                if (numero > maximo) {
                    maximo = numero;
                }
                if (numero < minimo) {
                    minimo = numero;
                }

        }

        System.out.println("\n--- Resultados ---");
        media = (double) suma / contador;
        System.out.println("Total de números introducidos: " + contador);
        System.out.println("Número máximo: " + maximo);
        System.out.println("Número mínimo: " + minimo);
        System.out.println("Media: " + media);
    
scanner.close();
}
}
