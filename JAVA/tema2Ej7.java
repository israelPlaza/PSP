
import java.util.Scanner;

public class tema2Ej7 {
    public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);

        System.out.println("Escribe tú número: ");
        int numero = sc.nextInt();
        int resultado = (numero / 8) +12;
        System.out.println("El número es: " + resultado);
    }
}
