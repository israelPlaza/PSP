import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio13 {
public static void main(String[] args) {
    int saldo;
    int f1, f2, f3; 
    String fig1, fig2, fig3;
    String[] figuras = {"Corazón", "Diamante", "Herradura", "Campana", "Limón"};
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    
    System.out.println("Bienvenido a la máquina tragaperras.");
        while (true) {
            try {
                System.out.print("¿Con cuántas monedas quieres jugar? ");
                saldo = scanner.nextInt();
                if (saldo > 0) {
                    break;
                } else {
                    System.out.println("Error: Debes empezar con al menos 1 moneda.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Introduce un número válido.");
                scanner.next(); // Limpia el buffer
            }
        }

        scanner.nextLine(); 

    
        while (saldo > 0) {

            System.out.println("\n--- Tienes " + saldo + " monedas. ---");
            System.out.print("Pulsa [Intro] para tirar (cuesta 1 moneda)...");
            
            scanner.nextLine();

            saldo--; 
            
            f1 = random.nextInt(5);
            f2 = random.nextInt(5);
            f3 = random.nextInt(5);
            // los números a figuras
            fig1 = figuras[f1];
            fig2 = figuras[f2];
            fig3 = figuras[f3];

            
            System.out.println("-----------------");
            System.out.println(fig1 + " | " + fig2 + " | " + fig3);
            System.out.println("-----------------");

           
            if (f1 == f2 && f2 == f3) {
                System.out.println("¡Enhorabuena, ha ganado 10 monedas!");
                saldo += 10;
            
            
            } else if (f1 == f2 || f1 == f3 || f2 == f3) {
                System.out.println("Bien, ha recuperado su moneda.");
                saldo++; 

            
            } else {
                System.out.println("Lo siento, ha perdido.");
            }
        }

        
        System.out.println("\nJUEGO TERMINADO.");
        System.out.println("Te has quedado sin monedas.");
        scanner.close();
}
}
