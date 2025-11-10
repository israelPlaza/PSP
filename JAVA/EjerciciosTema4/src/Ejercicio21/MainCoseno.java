package Ejercicio21;

public class MainCoseno {

    public static void main(String[] args) {
        
        Coseno calculadorCoseno = new Coseno();
        
        // Prueba 1: Coseno(0) debe ser 1
        double angulo1 = 0.0;
        int terminos1 = 10;
        double resultado1 = calculadorCoseno.calcularCoseno(angulo1, terminos1);
        
        System.out.println("--- Cálculo del Coseno (Prueba 1) ---");
        System.out.println("Coseno(" + angulo1 + ") = " + resultado1); 
        
        double angulo2 = 3.14159; 
        int terminos2 = 25;
        double resultado2 = calculadorCoseno.calcularCoseno(angulo2, terminos2);

        System.out.println("\n--- Cálculo del Coseno (Prueba 2) ---");
        System.out.println("Coseno(" + angulo2 + ") = " + resultado2);
    }
}