import java.util.Scanner;

public class Distancia {
    public static void main(String[] args) throws Exception {
    int milimetros;
     int centrimetros;
     int metros;
     Scanner sc = new Scanner(System.in);
     
    System.out.println("Primera medida en milimetros: ");
    milimetros=sc.nextInt();
    milimetros=milimetros/10;
    System.out.println("Segunda medida en centrimetros: ");
    centrimetros= sc.nextInt();
    System.out.println("Tercera medida en metros: ");
    metros=sc.nextInt();
    metros=metros*100;
    
    System.out.println("La medida toral es: "+(milimetros+metros+centrimetros)+"milimetros");
    }
}
