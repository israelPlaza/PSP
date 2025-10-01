
import java.util.Scanner;

public class tema2Ej1 {
    public static void main(String[] args) {

        float precioBase = 0.0f;
        float precioIva = 0.0f;
        float IVA = 0.21f;
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe el precio base: ");
        precioBase = sc.nextFloat();

        System.out.println("El 21% de IVA de este producto es "+ (precioBase * IVA));
        System.out.println("El precio final es: "+ (precioBase +(precioBase * IVA)));
    
    }
}
