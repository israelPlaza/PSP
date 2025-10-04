
import java.util.Scanner;

public class Tema2Ternario6 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un número:");
        int numero = sc.nextInt();

        String dato = numero >0 ? "positovo" : numero <0 ? "negativo" : "cero" ;
        System.out.println("Tú número es "+dato);

    }
}
