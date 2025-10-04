package EjerciciosTema2Ternario;

import java.util.Scanner;

public class Tema2Ternario7 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int unidades = 0;
        float precioUnidad = 0;
        
        System.out.println("¿ Cuántas unidades quieres comprar ?:");
        unidades = sc.nextInt();
        System.out.println("¿ Cuánto vale cada unidad ?");
        precioUnidad = sc.nextFloat();

        float descuento = unidades >10 ? 0.05f : 0.00f ;

        if (descuento == 0.05f) {
            
            System.out.println("Con descuento del 5%");
            System.out.println("El descuento:"+ ((descuento *100)));
            System.out.println("Precio final: "+((unidades*precioUnidad)-(descuento*100)+"€"));

        }else {
            System.out.println("Sin descuento");
            System.out.println("Precio final:"+ unidades*precioUnidad+"€");
        }

    }
}
