import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio16 {
public static void main(String[] args) {
    int A;
        Scanner scanner = new Scanner(System.in);

        System.out.println("El bloque try-catch se encuentra en 'main'.");

        try {
            
            A = leerEntero(scanner);
            System.out.println("Valor introducido: " + A);

        } catch (InputMismatchException e) {
            
            System.out.println("Error: Valor incorrecto (Capturado en 'main').");
        }

        scanner.close();
}
    public static int leerEntero(Scanner scanner) {
        System.out.print("Introduce un valor entero (en el método 'leerEntero'): ");
        int valor = scanner.nextInt(); 
        return valor;
    }
}
