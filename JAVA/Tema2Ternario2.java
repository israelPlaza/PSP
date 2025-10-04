
import java.util.Scanner;

public class Tema2Ternario2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tú número:");
        int numero= sc.nextInt();

        String dato = (numero % 2 ==0) ? "par" : "inpar" ;
        System.out.println("El número es "+dato);

    }
}
