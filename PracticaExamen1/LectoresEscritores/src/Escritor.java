public class Escritor extends  Thread {
    private int numeroEscritor;
    private BaseDatos bd;

    public  Escritor(int numeroEscritor, BaseDatos bd){
        this.numeroEscritor=numeroEscritor;
        this.bd=bd;
    }

    @Override
    public void run(){
        try {
            bd.escritura(numeroEscritor);
            Thread.sleep(2000);
            bd.saliendoEscritor(numeroEscritor);
        } catch (InterruptedException ex) {
        }
        
    }

}
