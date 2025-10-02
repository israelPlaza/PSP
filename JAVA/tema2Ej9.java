import java.util.Scanner;

public class tema2Ej9 {
    public static void main(String[] args) {
        
        int numero_magico = 12345679;
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce un número entre 1 y 9: ");
        int numero_usuario = sc.nextInt();

        numero_usuario *= 9; 
        numero_magico *= numero_usuario;
        System.out.println("El número mágico es: " + numero_magico);

    }
}
