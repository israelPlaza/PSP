public class Vehiculo extends Thread {

    private Puente puente;
    private int numero;

    public  Vehiculo(int numero, Puente puente){
        this.numero = numero;
        this.puente = puente;
    }

    @Override
    public  void run(){
        try {
            puente.entrada(numero);
            Thread.sleep(300);
            puente.salida(numero);
        } catch (InterruptedException ex) {
        }
    }


}
