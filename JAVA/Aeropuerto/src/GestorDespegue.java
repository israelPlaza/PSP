public class GestorDespegue {

    private boolean autorizarDespegue;
    private int aviones;
    private int avionetas;

    public GestorDespegue() {
        this.autorizarDespegue = true;
        this.aviones = 0;
        this.avionetas = 0;
    }

    public synchronized void despegarAvion(int identificador) throws InterruptedException {
        System.out.println("El avión " + identificador + " quiere entrar en pista");
        aviones++;
        while (!autorizarDespegue ) { // Prioridad a avionetas si están esperando
            wait();
        }
        autorizarDespegue = false;
        System.out.println("Despega avión número " + identificador);
        Thread.sleep(2000); // Simula el tiempo de despegue
        aviones--;
        autorizarDespegue = true;
        notifyAll();
    }

    public synchronized void despegarAvioneta(int identificador) throws InterruptedException {
        System.out.println("La avioneta " + identificador + " quiere entrar en pista");
        avionetas++;
        while (!autorizarDespegue || aviones > 0) { // Prioridad a aviones si están esperando
            wait();
        }
        autorizarDespegue = false;
        System.out.println("Despega avioneta número " + identificador);
        Thread.sleep(1000); // Simula el tiempo de despegue
        avionetas--;
        autorizarDespegue = true;
        notifyAll();
    }

    public void autorizarDespegue(int minutos) {
    }
}