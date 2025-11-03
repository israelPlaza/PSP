import java.util.Scanner;

public class Ejercicio5 {
public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de filas (n): ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) { //Para las filas

            for (int j = 1; j <= i; j++) { //para imprimir has el numero
                System.out.print(j);
            }
            for (int k = i - 1; k >= 1; k--) { //para imprimir del numero al 1
                System.out.print(k);
            }

            System.out.println();//salto de linea
        }

        scanner.close();
}
}
