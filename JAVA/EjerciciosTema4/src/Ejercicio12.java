import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio12 {
public static void main(String[] args) {
    int ancho = 6;
    int altura = 3;
    int opcion;
    int temp; 
    Scanner scanner = new Scanner(System.in);

        
        while (true) {
            
            System.out.println("\n--- Rectángulo Actual ---");
            // Bucle para las filas (altura)
            for (int i = 1; i <= altura; i++) {
                // Bucle para las columnas (ancho)
                for (int j = 1; j <= ancho; j++) {
                    // Imprime '*' si es el borde
                    if (i == 1 || i == altura || j == 1 || j == ancho) {
                        System.out.print("*");
                    } else {
                        // Imprime espacio si es el interior
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            
            System.out.println("\n1. Agrandarlo");
            System.out.println("2. Achicarlo");
            System.out.println("3. Cambiar la orientación");
            System.out.println("4. Salir");
            
            try {
                System.out.print("Elige una opción: ");
                opcion = scanner.nextInt();
                switch (opcion) {
                    case 1: // Agrandar
                        ancho++;
                        altura++;
                        break;
                        
                    case 2: // Achicar (con validación)
                        if (ancho > 2 && altura > 2) {
                            ancho--;
                            altura--;
                        } else {
                            System.out.println("Error: No se puede reducir más (mínimo 2x2).");
                        }
                        break;
                        
                    case 3: // Cambiar orientación (Intercambio)
                        temp = ancho;
                        ancho = altura;
                        altura = temp;
                        break;
                        
                    case 4: // Salir
                        System.out.println("¡Hasta luego!");
                        scanner.close(); 
                        return;
                        
                    default:
                        System.out.println("Opción no válida (debe ser 1-4).");
                }
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número entero.");
                scanner.next(); // Limpia el buffer del scanner
            }
        }
}
}
