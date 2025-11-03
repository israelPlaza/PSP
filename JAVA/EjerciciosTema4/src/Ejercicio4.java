
import java.util.Scanner;

public class Ejercicio4 {
public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    int media=0;
    int suma=0;
    int contador=0;
    int numero;
    
    do { 
        System.out.println("Escribe el número:");
        numero=sc.nextInt();
        contador++;
        suma=numero+suma;
        
    } while (suma<=10000);
    media=suma/contador;

    System.out.println("La suma de los numeros es: "+suma);
    System.out.println("La cantidad de los numeros ingresados: "+contador);
    System.out.println("La media de los numeros es: "+media);

sc.close();
}
}
