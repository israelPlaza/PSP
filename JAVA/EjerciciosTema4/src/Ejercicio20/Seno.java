package Ejercicio20;

public class Seno {
    private double angulo;
    private int numero;

 
    public Seno() {
        this.angulo = 0;
        this.numero = 0;
    }
    
    
    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double angulo) {
        this.angulo = angulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double factorial(int n) {
        if (n < 0) {
            return Double.NaN; 
        }
        double resultado = 1.0;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public double calcularSeno(double angulo, int numeroTerminos) {
        double suma = 0.0;

        for (int i = 0; i < numeroTerminos; i++) {
            // Calculamos cada término de la serie
            double numerador = Math.pow(-1, i) * Math.pow(angulo, 2 * i + 1);
            double denominador = factorial(2 * i + 1);
            double termino = numerador / denominador;
            
            // Acumulamos el término
            suma += termino;

            // Para saber los valores indicados
            if (i == 3 || i == 12 || i == 18 || i == 24) {
                System.out.println("Valor de la serie en i = " + i + ": " + suma);
            }
        }
        return suma;
    }
}