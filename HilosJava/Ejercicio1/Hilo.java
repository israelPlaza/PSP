public class Hilo extends Thread{
    int numero;

    public Hilo(int numero){
        this.numero = numero;
    }

    public void run(){

        System.out.println("Soy el hilo "+numero);

    }

}
