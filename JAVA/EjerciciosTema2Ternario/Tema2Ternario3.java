package EjerciciosTema2Ternario;

import java.util.Scanner;

public class Tema2Ternario3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe tú numero: ");
        int numero = sc.nextInt();

        String dato = numero  >= 0 ? "positivo" : "negativo" ;
        System.out.println("Tú número es de signo "+ dato);

    }
}
