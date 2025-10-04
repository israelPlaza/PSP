
import java.util.Scanner;

public class Tema2Ternario1 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe el primer número:");
        int primero = sc.nextInt();
        System.out.println("Escribe el segundo númeero:");
        int segundo = sc.nextInt();

        int mayor = primero > segundo ? primero : segundo ;
        System.out.println("El número mayor es: "+mayor);

    }
}
