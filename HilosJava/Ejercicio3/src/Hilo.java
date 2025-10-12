public class Hilo extends Thread{
    int numero;

    public Hilo(int numero){
        this.numero = numero;
    }

    @Override
    public  void run(){
        System.out.println("Es el hilo "+numero);

    }

}
