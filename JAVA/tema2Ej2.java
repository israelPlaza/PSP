
import java.util.Scanner;

public class tema2Ej2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float celsius=0;
        
        System.out.println("Escribe la temperatua celsius: ");
        celsius= sc.nextFloat();

        System.out.println("La tamperatura es: "+ ((1.8 * celsius)+32)+ "ºF");

    }
}
