import java.util.Scanner;

public class Ejercicio11 {
public static void main(String[] args) {
   
    int numero;
    int temp=0;
    int digito;
    int contadorSuerte = 0;
    int contadorMalaSuerte = 0;
    Scanner scanner = new Scanner(System.in);

        
        System.out.print("Introduce un número entero: ");
        numero = scanner.nextInt();
        scanner.close();

        do {
            // Para obtner el ultimo digito
            digito = (temp % 10);

            if (digito == 3 || digito == 7 || digito == 8 || digito == 9) {
                contadorSuerte++;
            } else {
                contadorMalaSuerte++;
            }
            //Quitamos el ultimo digito
            temp = temp / 10;

        } while (temp > 0); 

       
        System.out.println("\n--- Análisis del número " + numero + " ---");
        System.out.println("Dígitos de la suerte encontrados: " + contadorSuerte);
        System.out.println("Dígitos de la mala suerte encontrados: " + contadorMalaSuerte);
        if (contadorSuerte > contadorMalaSuerte) {
            System.out.println("El número ES afortunado.");
        } else {
            System.out.println("El número NO es afortunado.");
        }
}
}
