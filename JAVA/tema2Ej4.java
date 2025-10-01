
import java.util.Scanner;

public class tema2Ej4 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        float peso=0.0f;
        float altura=0.0f;

        System.out.println("Ingrese el peso(Kg): ");
        peso= sc.nextFloat();

        System.out.println("Ingrese la altuira(Cm): ");
        altura= sc.nextFloat();

        System.out.println("Su IMC: "+ (peso / (altura * altura)));


    }
}
