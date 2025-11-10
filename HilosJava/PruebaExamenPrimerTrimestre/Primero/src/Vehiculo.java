public class Vehiculo extends Thread {
    Puente puente;
    private int numero;

    public Vehiculo(int numero, Puente puente){
        this.puente=puente;
        this.numero=numero;
    }

    @Override
    public void run(){
        try {
            puente.entrar(numero);
            Thread.sleep(3000);
            puente.salir(numero);

        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        
    }


}
