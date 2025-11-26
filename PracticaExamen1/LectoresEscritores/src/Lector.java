public class Lector extends Thread {
    private int numeroLector;
    private BaseDatos bd;

    public  Lector(int numeroLector, BaseDatos bd){
        this.numeroLector=numeroLector;
        this.bd=bd;
    }

    @Override
    public void run(){
        try {
            bd.lectura(numeroLector);
            Thread.sleep(2000);
            bd.salidaLector(numeroLector);
        } catch (InterruptedException ex) {
        }
        
    }

}
