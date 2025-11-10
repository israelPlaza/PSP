package Ejercicio20;

public class MainSeno {

    public static void main(String[] args) {
        double anguloPrueba = 3.14159; // Aprox. PI
        int terminosPrueba = 25;

        // 1. Interrupcion para inspeccionar que el constructor funciona.
        Seno calculadorSeno = new Seno(); 
        
        System.out.println("--- Cálculo del Seno ---");
        System.out.println("Probando con ángulo = " + anguloPrueba + " rad y " + terminosPrueba + " términos.");
        
        // 2. Interrupcion para poder "Entrar"  en el método.
       
        // 3. Interrupcion Dentro del método  para ver cómo evoluciona la suma
        //    en cada iteración.
        double resultado = calculadorSeno.calcularSeno(anguloPrueba, terminosPrueba);

        System.out.println("\n--- Resultado Final ---");
        System.out.println("Seno(" + anguloPrueba + ") = " + resultado);
    }
}