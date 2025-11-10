package Ejercicio19;

public class PruebaGatos {

    public static void main(String[] args) {

        Gato gato1 = new Gato("Misi", 2);
        gato1.imprimir();


        System.out.println("\nCreando Gato 2 ('Al', 4)...");
        Gato gato2 = new Gato("Al", 4);
        // El gato se crea, pero 'nombre se queda a null
        gato2.imprimir(); 

        System.out.println("\nCreando Gato 3 ('Garfield', -1)...");
        Gato gato3 = new Gato("Garfield", -1);
        // El gato se crea, pero 'edad' queda a 0
        gato3.imprimir();
        
        
        System.out.println("\nIntentando setEdad(3) a Gato 1...");
        gato1.setEdad(3);
        gato1.imprimir();

        
        System.out.println("\nIntentando setNombre('Bo') a Gato 1...");
        gato1.setNombre("Bo");
        
    
        System.out.println("\nIntentando setEdad(-5) a Gato 1...");
        gato1.setEdad(-5);
        
        System.out.println("\nEstado final de Gato 1:");
        gato1.imprimir(); 
    }
}