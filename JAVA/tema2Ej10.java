import java.util.Scanner;

public class tema2Ej10 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Precio del producto: ");
        float precio = sc.nextFloat();
        System.out.print("Cantidad introducida: ");
        float cantidad = sc.nextFloat();
        
        float cambio = cantidad - precio;
        System.out.println("Cambio: " + cambio + "€");
        
        int centimos = Math.round(cambio * 100); //esto es para redondear
        
        int[] valores = {2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};
        String[] denominaciones = {"20€", "10€", "5€", "2€", "1€", "50c", "20c", "10c", "5c", "2c", "1c"};
        
        for(int i = 0; i < valores.length; i++) {
            int cantidadDenominacion = centimos / valores[i];
            if(cantidadDenominacion > 0) {
                System.out.println(denominaciones[i] + ": " + cantidadDenominacion);
                centimos %= valores[i];
            }
        }

    }
}
