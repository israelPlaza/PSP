enum Sentido {LIBRE, A, B}
enum Tipo {AMBULANCIA, COCHE}

public class Puente {
    private Sentido sentido;
    private int cantidad;
    private int capacidad;
    private int esperandoEnA;
    private int esperandoEnB;
    private int esperandoAmbulancias;

    public Puente(int numero) {
        this.capacidad = numero;
        this.cantidad = 0;
        this.sentido = Sentido.LIBRE;
        this.esperandoEnA = 0;
        this.esperandoEnB = 0;
        this.esperandoAmbulancias = 0;
    }

    public synchronized void entrarA(int numero, Tipo tipo) throws InterruptedException {
        esperandoEnA++;
        System.out.println(tipo + " " + numero + " quiere entrar por A. " + esperandoEnA + " esperando");

        while (cantidad == capacidad || sentido == Sentido.B || esperandoAmbulancias > 0) {
            wait();
        }

        esperandoEnA--;
        cantidad++;
        sentido = Sentido.A;
        System.out.println(tipo + " " + numero + " ha entrado por A");
    }

    public synchronized void entrarB(int numero, Tipo tipo) throws InterruptedException {
        esperandoEnB++;
        System.out.println(tipo + " " + numero + " quiere entrar por B. " + esperandoEnB + " esperando");

        while (cantidad == capacidad || sentido == Sentido.A || esperandoAmbulancias > 0) {
            wait();
        }

        esperandoEnB--;
        cantidad++;
        sentido = Sentido.B;
        System.out.println(tipo + " " + numero + " ha entrado por B");
    }

    public synchronized void entrarAmbulanciasA(int numero, Tipo tipo) throws InterruptedException {
        esperandoAmbulancias++;
        System.out.println(tipo + " " + numero + " (ambulancia) quiere entrar por A");

        while (cantidad == capacidad || (sentido == Sentido.B && cantidad > 0)) {
            wait();
        }

        esperandoAmbulancias--;
        cantidad++;
        sentido = Sentido.A;
        System.out.println(tipo + " " + numero + " entra por A (PRIORIDAD)");
    }

    public synchronized void entrarAmbulanciasB(int numero, Tipo tipo) throws InterruptedException {
        esperandoAmbulancias++;
        System.out.println(tipo + " " + numero + " (ambulancia) quiere entrar por B");

        while (cantidad == capacidad || (sentido == Sentido.A && cantidad > 0)) {
            wait();
        }

        esperandoAmbulancias--;
        cantidad++;
        sentido = Sentido.B;
        System.out.println(tipo + " " + numero + " entra por B (PRIORIDAD)");
    }

    public synchronized void salir(int numero, Tipo tipo) {
        cantidad--;
        System.out.println(tipo + " " + numero + " abandona el puente");

        if (cantidad == 0) {
            sentido = Sentido.LIBRE;
        }

        notifyAll();
    }
}
