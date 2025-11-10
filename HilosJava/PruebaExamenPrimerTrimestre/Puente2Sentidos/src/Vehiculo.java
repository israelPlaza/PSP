public class Vehiculo extends Thread {
    private Puente puente;
    private int numero;
    private  Sentido sentido;

    public Vehiculo(Puente puente,Sentido sentido, int numero){
        this.puente=puente;
        this.sentido=sentido;
        this.numero=numero;
    }

    @Override
    public void run(){

        if (sentido==sentido.A) {
            try {
                puente.entradaA(this.numero);
            } catch (InterruptedException ex) {
            }
        } else {
            try {
                puente.entradaB(numero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(numero);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        puente.salir(numero);

    }

}
