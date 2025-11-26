public class Hilo extends Thread {
Puente puente;
int numero;

    public Hilo(Puente puente, int numero){
        this.puente= puente;
        this.numero= numero;
    }
    @Override
    public void  run(){
        try {
            puente.entrar(numero);
            Thread.sleep(2000);
            puente.salir(numero);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
