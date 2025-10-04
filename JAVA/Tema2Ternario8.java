
import java.util.Scanner;

public class Tema2Ternario8 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int hora = 0;

        System.out.println("Maca el digito de la hora [0-24]");
        hora = sc.nextInt();

        String dia = hora <12 ? "mañana" : hora <21 ? "tarde" : "noche";
        System.out.println("Es por la "+dia);

    }
}
