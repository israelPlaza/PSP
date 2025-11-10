import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio17 {
public static void main(String[] args) {
   Scanner scanner = new Scanner(System.in);
    double maximo;
    double numero;
    int numerosLeidos = 0;
    int errorCount = 0;
       

        System.out.println("Introduce 10 números con parte decimal.");
        // Mensaje actualizado para que uses coma o punto según tu sistema
        System.out.println("Por favor, usa el separador decimal de tu sistema (ej. 12,5 o 12.5).");

        // Bucle hasta leer 10 números correctos
        while (numerosLeidos < 10) {
            
            System.out.print("Introduce el número " + (numerosLeidos + 1) + "/10: ");

            try {
                // Intentamos leer el número
                numero = scanner.nextDouble();

                // Si la lectura es correcta:
                numerosLeidos++; 

                // Actualizamos el máximo
                if (numero > maximo) {
                    maximo = numero;
                }

            } catch (InputMismatchException e) {
                
                // Si la lectura falla:
                errorCount++;
                System.out.println(" -> Error " + errorCount + ": Valor no válido. Inténtalo de nuevo.");
                
                // Limpiamos el buffer del scanner
                scanner.next(); 
            }
        } // Fin del while

        // --- Mostrar resultados ---
        System.out.println("\n--- Proceso completado ---");
        System.out.println("El número más alto introducido es: " + maximo);
        System.out.println("Se produjeron un total de " + errorCount + " errores de entrada.");

        scanner.close();
}
}
