
import java.util.Scanner;

public class Ejercicio2 {
public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    String jugador1;
    String jugador2;

    System.out.println("JUGADOR 1");
    System.out.println("Elige PIEDRA, PAPEL, TIJERA");
    jugador1=sc.nextLine();
    
    System.out.println("JUGADOR 2");
    System.out.println("Elige PIEDRA, PAPEL, TIJERA");
    jugador2=sc.nextLine();

    if (jugador1.equalsIgnoreCase("piedra")
    ||jugador1.equalsIgnoreCase("papel")
    ||jugador1.equalsIgnoreCase("tijera")){
        
        System.out.println("jugador 1:"+jugador1.toUpperCase());
    } else {
        System.out.println("Escribe una de las tres palabras");
    }

    if (jugador2.equalsIgnoreCase("piedra")
    ||jugador2.equalsIgnoreCase("papel")
    ||jugador2.equalsIgnoreCase("tijera")){
        
        System.out.println("jugador 2:"+jugador2.toUpperCase());
    } else {
        System.out.println("Escribe una de las tres palabras");
    }

    if (jugador1.equalsIgnoreCase(jugador2)) {
        System.out.println("EMPATE");
    }

    if (jugador1.equalsIgnoreCase("piedra") 
    && jugador2.equalsIgnoreCase("tijera")) {
        System.out.println("GANA JUGADOR 1");    
    }if (jugador1.equalsIgnoreCase("tijera") 
    && jugador2.equalsIgnoreCase("papel")) {
        System.out.println("GANA JUGADOR 1");    
    }if (jugador1.equalsIgnoreCase("papel") 
    && jugador2.equalsIgnoreCase("piedra")) {
        System.out.println("GANA JUGADOR 1");    
    }if (jugador2.equalsIgnoreCase("piedra") 
    && jugador1.equalsIgnoreCase("tijera")) {
        System.out.println("GANA JUGADOR 2");    
    }if (jugador2.equalsIgnoreCase("tijera") 
    && jugador1.equalsIgnoreCase("papel")) {
        System.out.println("GANA JUGADOR 2");    
    }if (jugador2.equalsIgnoreCase("papel") 
    && jugador1.equalsIgnoreCase("piedra")) {
        System.out.println("GANA JUGADOR 2");    
    }

    sc.close();
}
}
