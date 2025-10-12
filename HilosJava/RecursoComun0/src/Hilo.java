public class Hilo extends Thread{
    int numero;
    Contador contador;

    public Hilo(int numero, Contador contador){
        this.numero=numero;
        this.contador=contador;

    }
    @Override
    public  void run(){
        System.out.println("Hilo "+numero);
        for (int i = 0; i < 100; i++) {
            contador.contar();
        }
    }

}
