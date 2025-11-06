import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio14 {
public static void main(String[] args) {
    int dato;
    Scanner scanner = new Scanner(System.in);

    System.out.print("Introduce un valor entero A: ");

    
    try {
      
        dato = scanner.nextInt();
            
        System.out.println("Valor introducido: " + dato);

        } catch (InputMismatchException e) {
            
        System.out.println("Valor introducido incorrecto");
        }

        scanner.close();
}
}
