
import java.util.Scanner;

public class tema2Ej8 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el primer número: ");
        int primer = sc.nextInt();
        System.out.println("Escribe el segundo número:");
        int segundo = sc.nextInt();
        
        System.out.println("Suma: " + (primer + segundo));
        System.out.println("Resta: " + (primer - segundo));
        System.out.println("Multiplicación: " + (primer * segundo));
        System.out.println("División: " + (primer / segundo));
    }
}
