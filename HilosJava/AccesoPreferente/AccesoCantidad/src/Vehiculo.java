public class Vehiculo extends Thread{
    private Puente puente;
    private int numero;


    public Vehiculo(int numero, Puente puente){
        this.numero = numero;
        this.puente = puente;
    }

    @Override
    public void run(){
        try {
            puente.entrar(numero);
            sleep(3000);
            puente.salida(numero);
        } catch (InterruptedException ex) {
        }
    }
}
