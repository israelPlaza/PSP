import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio18 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numero;

        while (true) {
            try {
                System.out.print("\nIntroduce un número (0 para salir): ");
                numero = scanner.nextInt();
                
            } catch (InputMismatchException e) {
                System.out.println("Error de entrada: Debes introducir un número entero.");
                scanner.next(); // Limpiar buffer
                continue;
            }

            if (numero == 0) {//esto es para salir del bucle
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.println("Probando imprimePositivo(" + numero + "):");
            try {
                
                imprimePositivo(numero);
            } catch (Exception e) {
             
                System.out.println(" Error : " + e.getMessage());
            }

            
            System.out.println("imprimeNegativo(" + numero + "):");
            try {
              
                imprimeNegativo(numero);
            } catch (Exception e) {
                
                System.out.println("   Error capturado: " + e.getMessage());
            }

        } // Fin del while

        scanner.close();
    
}
 public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            
            throw new Exception("El valor es negativo (" + p + ")");
        }
        System.out.println("OK Positivo: " + p);
    }

    
    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            
            throw new Exception("El valor es positivo o cero (" + n + ")");
        }
        System.out.println("OK Negativo: " + n);
    }
}
