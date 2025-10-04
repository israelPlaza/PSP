package EjerciciosTema2Ternario;
import java.util.Scanner;

public class Tema2Ternario4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.print("Escribe tú número: ");
        int numero = sc.nextInt();
        
        int absoluto = (numero >= 0) ? numero : -numero;
        System.out.println("Valor absoluto: " + absoluto);
    
    }
}
