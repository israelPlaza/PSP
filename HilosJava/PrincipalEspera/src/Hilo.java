public class Hilo extends Thread{
private int numero;
    public  Hilo(int numero){
        this.numero = numero;
    }

    @Override
    public void run(){
        System.out.println("el hilo "+numero);
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }

}
