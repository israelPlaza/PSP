
import java.util.Scanner;

public class tema2Ej3 {
    public static void main(String[] args) {
    
        float pies=0;
        float pulgadas=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe los pies: ");
        pies= sc.nextFloat();

        System.out.println("Escribe las pulgadas: ");
        pulgadas= sc.nextFloat();

        float totalPulgadas= (pies *12) + pulgadas;
        float distanciaCentimetros= totalPulgadas * 2.54f;

        System.out.println("La didtancia en centimetros es " + distanciaCentimetros);

    }
}
