
import java.util.Scanner;

public class Ejercicio3 {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int dato;
    int contador=1;
    int total=0;
    int suma=0;

    System.out.println("Escribe tú número positivo:");
    dato=sc.nextInt();

    //validacion
    if(dato>0){
        suma=dato+1;
        contador=dato+100;
        
        System.out.println("Numero correcto, empieza la suma...");
        for (int i = suma; i < contador; i++) {

            System.out.println(total+=i);
        }

    }else{
        System.out.println("El número tiene que ser mayor que 0");
    }
sc.close();
}
}
