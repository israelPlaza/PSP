
import java.util.Scanner;

public class tema2Ej11 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe tú primer número: ");
        int primer = sc.nextInt();
        System.out.println("Escribe tú segundo número: ");
        int segundo = sc.nextInt();
        
        if (primer>segundo) {
            System.out.println("ordenado de menor a mayor: "+segundo+", "+primer);
        }else{
            System.out.println("ordenado de menor a mayor: "+primer+", "+segundo);
        }

    }
}
