
import java.util.Scanner;

public class Radares {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe la distancia(metros): ");
        int distancia = sc.nextInt();
        System.out.println("Escribe la velocidad máxima(KM/h): ");
        int velocidad= sc.nextInt();
        System.out.println("Segundos en recorrer el tramo: ");
        int recorrido= sc.nextInt();

        //castemos para pasr  la velocidad media
        double velocidadMediaKm = (double) distancia / recorrido * 3.6;

        if (velocidadMediaKm <= velocidad) {
            System.out.println("OK");
        }
        
        //CALulamos los puntos
        double puntos = velocidad * 1.20;
        
        if (velocidadMediaKm >= puntos) {
                System.out.println("PUNTOS");
            } else {
                System.out.println("MULTA");
            }
    }
}
