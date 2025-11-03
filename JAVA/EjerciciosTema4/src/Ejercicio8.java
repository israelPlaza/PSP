import java.util.Scanner;

public class Ejercicio8 {
public static void main(String[] args) {

        long numero;
        int posicion;
        long temp;
        int longitud = 0;
        int digitosDerecha;
        long divisor = 1; // Se inicializa a 1 para la multiplicación
        long parteIzquierda;
        long parteDerecha;
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Introduce un número (mínimo 2 dígitos): ");
        numero = scanner.nextLong();

        System.out.print("Introduce la posición para partir (desde 2): ");
        posicion = scanner.nextInt();

        

        //Hacemos copia par no perderlo
        temp = numero;
        while (temp > 0) {
            temp = temp / 10;
            longitud++;
        }

        
        digitosDerecha = longitud - posicion;
        
        for (int i = 0; i < digitosDerecha; i++) {
            divisor *= 10;
        }
        
        // Para partir el número
        parteIzquierda = numero / divisor;
        parteDerecha = numero % divisor;

        
        System.out.println("\n--- Resultado ---");
        System.out.println("Número original: " + numero);
        System.out.println("Posición de corte: " + posicion);
        System.out.println("Parte izquierda: " + parteIzquierda);
        System.out.println("Parte derecha: " + parteDerecha);
        

scanner.close();
}
}
