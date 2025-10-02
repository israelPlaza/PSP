
import java.util.Scanner;

public class tema2Ej5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el día de nacimeinto: ");
        int dia = sc.nextInt();
        System.out.println("Escribe el mes:");
        int mes = sc.nextInt();
        System.out.println("Escribe el año:");
        int anio = sc.nextInt();

        System.out.printf("Fecha de nacimiento: %02d/%02d/%04d\n", dia, mes, anio);

    }
}
