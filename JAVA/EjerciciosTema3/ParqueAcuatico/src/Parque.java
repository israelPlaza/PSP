
import java.util.Scanner;

public class Parque {
    public static void main(String[] args) {
        final float INFANTIL = 15.50f;
        final float ADULTO = 20.00f;
        Scanner sc = new Scanner(System.in);
        int cantidadInfantil=0;
        int cantidadadAdulto=0;

        System.out.println("¿ Cuántas entradas infantiles son: ?");
        cantidadInfantil= sc.nextInt();
        System.out.println("¿ Cuántas entradas de adulto son: ?");
        cantidadadAdulto= sc.nextInt();

        float suma = (cantidadInfantil * INFANTIL)+(cantidadadAdulto * ADULTO);
        if (suma >=100) {
            System.out.println("Elprecio sin descuento es: "+suma+"€");
            System.out.println("Con el descuento es: "+(suma - (suma* 0.05))+"€");
        } else {
            System.out.println("El precio es: "+suma+"€");
        }

    }
}
