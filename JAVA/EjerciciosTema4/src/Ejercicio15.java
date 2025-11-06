import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio15 {
public static void main(String[] args) {
    int a;
    int b;
    int resultado;
    Scanner scanner = new Scanner(System.in);

         try {
            System.out.print("Introduce el valor entero A: ");
            a = scanner.nextInt();
            System.out.print("Introduce el valor entero b: ");
            b = scanner.nextInt();
            resultado = a / b;
            System.out.println("El resultado de A / b es: " + resultado);

        } catch (InputMismatchException e) {
            
            
            System.out.println("Error: Valor introducido incorrecto. Debes introducir números enteros.");
            
        } catch (ArithmeticException e) {
            
            
            System.out.println("Error: No se puede dividir por cero.");
        }

    scanner.close();
}
}
