public class Puente {

    private Sentido sentido;
    private int numero;
    private int colaA;
    private int colaB;
    private int capaciad=0;
    
    public Puente() {
        this.sentido = Sentido.LIBRE;
        this.numero = numero;
        this.capaciad=capaciad;
        this.colaA=0;
        this.colaB=0;

    }

    public synchronized void entradaA(int numero) throws InterruptedException{
        colaA++;
        System.out.println("vehiculo "+numero+" quiere entrar");
        while (capaciad>2 || sentido==Sentido.B || colaA < colaB) {
            wait();
        }
        colaA--;
        capaciad++;
        sentido=Sentido.A;
        System.out.println("vehiculo "+numero+" entra por A esperando "+colaA);

    }

    public synchronized void entradaB(int numero) throws InterruptedException{
        colaB++;
        System.out.println("vehiculo "+numero+" quiere entrar");
        while (capaciad>2 || sentido==Sentido.A || colaB < colaA) {
            wait();
        }
        colaB--;
        capaciad++;
        sentido=Sentido.B;
        System.out.println("vehiculo "+numero+" entra por B esperando "+colaB);
    }

    public  synchronized void salir(int numero){
        capaciad--;
        System.out.println("vehiculo "+numero+" sale del puente");
        if (capaciad==0) {
            this.sentido=Sentido.LIBRE;
        }
        notifyAll();
    }

}
