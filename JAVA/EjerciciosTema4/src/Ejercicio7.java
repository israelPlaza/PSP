import java.util.Scanner;

public class Ejercicio7 {
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
        int altura = 0;

        
                System.out.print("Por favor, introduzca la altura (impar >= 3): ");
                altura = scanner.nextInt();

                if (altura >= 3 && altura % 2 != 0) {
                   
                } else {
                    System.out.println("Error: La altura debe ser un número IMPAR y MAYOR O IGUAL a 3.");
                }
        
        
        System.out.println("--- Reloj de altura " + altura + " ---");

        int mitad = altura / 2;

        // --- PARTE SUPERIOR (Incluyendo el centro) ---
        for (int i = 0; i <= mitad; i++) {
            // Imprimir espacios
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Imprimir asteriscos
            for (int j = 0; j < altura - (2 * i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // --- PARTE INFERIOR (Excluyendo el centro) ---
        for (int i = mitad - 1; i >= 0; i--) {
            // Imprimir espacios
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // Imprimir asteriscos
            for (int j = 0; j < altura - (2 * i); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
}
}
