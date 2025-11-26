public class Coche extends Thread{

    private String sentido;
    private Puente puente;

    public Coche(String sentido, Puente puente){
        this.sentido=sentido;
        this.puente=puente;
    }

    @Override
    public void run(){
        try {
            puente.llegar_al_puente(sentido);
            puente.cruzar_puente(sentido);
            Thread.sleep(2000);
            puente.salir_del_puente(sentido);

        } catch (InterruptedException e) {
        }
    }

}
