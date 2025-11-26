public class Puente {

private Hilo hilo;
private  int numero;
private boolean esperando = false;

    public Puente() {
       
    }

    public synchronized void entrar(int numero) throws InterruptedException{
        System.out.println("Coche "+numero+" quiere entrar.");

        while (esperando ==true) { 
            wait();
        }

        System.out.println("Coche "+numero+" ha entrado en el puente.");

    }

    public synchronized void salir(int numero){
        System.out.println("Coche "+numero+" saliendo del puente");
        esperando=true;
        notifyAll();
    }


}
