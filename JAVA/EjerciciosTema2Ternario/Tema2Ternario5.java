package EjerciciosTema2Ternario;

import java.util.Scanner;

public class Tema2Ternario5 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe un año: ");
        int anio = sc.nextInt();

        String dato = (anio % 4 ==0 && anio % 100 !=0) ? "bisiesto" : "no bisiesto" ;
        System.out.println("El año es "+dato);

    }
}
