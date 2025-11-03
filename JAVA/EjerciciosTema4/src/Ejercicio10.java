import java.util.Scanner;

public class Ejercicio10 {
public static void main(String[] args) {
    long numero;
    long resultado;
    long primerDigito;
    long resto;
    long potencia = 1;
    long temp; 
    Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce un número: ");
        numero = scanner.nextLong();
        scanner.close();

        
        
        if (numero < 10 && numero > -10) { // Comprobamos también negativos por si acaso
            resultado = numero;
        } else {
            
            temp = numero;
            while (temp >= 10 || temp <= -10) { // Mientras temp tenga 2 o más dígitos
                temp = temp / 10;
                potencia *= 10;
            }
            
            // 3.2. Separar las piezas
            primerDigito = numero / potencia;
            resto = numero % potencia; 
           
            resultado = (resto * 10) + primerDigito;
        }

        System.out.println("El número original es: " + numero);
        System.out.println("El número rotado es: " + resultado);
}
}
