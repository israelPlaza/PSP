import java.util.Scanner;

public class tema2Ej6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese valor de x: ");
        float x = sc.nextFloat();
        
        float resultado = x*x + 3*x + 5;
        System.out.println("El polinomio de "+x +" es " + resultado);
    }
}
