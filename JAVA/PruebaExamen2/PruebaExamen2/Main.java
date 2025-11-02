
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
    float tarifaGeneralPorHoras= 2.5f;
    Scanner sc= new Scanner(System.in);



    //coche metido por el usuario
    System.out.println("Escribe la matricula del coche: ");
    String matricula=sc.nextLine();
    System.out.println("Marque etiqueta ambiental[A,B,C,0]: ");
    String etiqueta=sc.nextLine();
    System.out.println("Escriba los minutos estacionados: ");
    int minutos=sc.nextInt();
    System.out.println("Escribe si tienes abono [true ó false]: ");
    boolean abono=sc.nextBoolean();





    //creacion de los objetos coche
    Vehiculo vehiculo1=new Vehiculo("1234bcd", "B", 75, true);
    vehiculo1.calcularImporte(tarifaGeneralPorHoras);

    Vehiculo vehiculo2=new Vehiculo(matricula,etiqueta,minutos,abono);
    vehiculo2.calcularImporte(tarifaGeneralPorHoras); 

    //Mostramos los vehiculos
    System.out.println("Vehiculo 1:");
    System.out.println(vehiculo1.toString());
    System.out.println("");
    System.out.println("Vehiculo 2:");
    System.out.println(vehiculo2.toString());
}
}
