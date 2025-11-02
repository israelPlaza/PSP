
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) throws Exception {
    Scanner sc= new Scanner(System.in);
    int dato=0;
    float tarta= 0.0f;
    float total;
    float nata=0.0f;
    float nombre;
    
     
    mostrarMenu();
    dato=sc.nextInt();
    sc.nextLine();//limpar buffer
    switch (dato) {
        case 1:
            tarta=18.00f;
            System.out.println("Has elegido tarta de Manzana");
            nata=mostrarExtraNata(sc);
            System.out.println(nata);
            nombre=mostrarExtraNombre(sc);
            System.out.println("Precio total de la tarta es: "+(tarta+nata+nombre)+"€");
            break;
        case 2:
            tarta=16.00f;
            System.out.println("Has elegido tarta de Fresas.");
            nata=mostrarExtraNata(sc);
            System.out.println(nata);
            nombre=mostrarExtraNombre(sc);
            System.out.println("Precio total de la tarta es: "+(tarta+nata+nombre)+"€");
            break;
        case 3:
            tarta=14.00f;
            System.out.println("Has elegido tarta de Chocolate negro.");
            nata=mostrarExtraNata(sc);
            System.out.println(nata);
            nombre=mostrarExtraNombre(sc);
            System.out.println("Precio total de la tarta es: "+(tarta+nata+nombre)+"€");
            break;
        case 4:
            tarta=15.00f;
            System.out.println("Has elegido tarta de Chocolate blanco.");
            nata=mostrarExtraNata(sc);
            System.out.println(nata);
            nombre=mostrarExtraNombre(sc);
            System.out.println("Precio total de la tarta es: "+(tarta+nata+nombre)+"€");
            break;    
        default:
            throw new AssertionError();
        }
    
    
    sc.close();
    }
    public static void mostrarMenu(){
        System.out.println("===============MENÚ===============");
        System.out.println("[1] Tarta de Manzana-----------18€");
        System.out.println("[2] Tarta de Freas-------------16€");
        System.out.println("[3] Tarta de Chocolate negro---14€");
        System.out.println("[4] Tarta de Chocolate blanco--15€");
        
    }
    public static  float mostrarExtraNata(Scanner sc) {
        float nata;
        String nataSn;
        
        System.out.println("==============Extras==============");
        System.out.println(" ¿Quieres añadir nata? S/N   2,50€");
        nataSn= sc.nextLine();
        if (nataSn.equalsIgnoreCase("s")) {
            return nata=2.50f;
        } else {
            return nata=0.0f;
        }
        
    }
    public static float mostrarExtraNombre(Scanner sc) {
        float nombre;
        String nombreSn;

        System.out.println("==============Extras================");
        System.out.println(" ¿Quieres añadir nombre? S/N   2,75€");
        nombreSn= sc.nextLine();
        if (nombreSn.equalsIgnoreCase("s")) {
            return nombre=2.75f;
        } else {
            return nombre=0.0f;
        }
        
    }

   
}
