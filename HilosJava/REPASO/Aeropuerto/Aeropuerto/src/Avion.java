public class Avion extends Thread{

    private int identificador;
    private GestorAeropuerto ga;
     private Temporizador tp;
    public Avion(int identificador,GestorAeropuerto ga, Temporizador tp){
        this.ga=ga;
        this.identificador=identificador;
        this.tp=tp;
    }
    public void run(){
        try {
            ga.despegarAvion(identificador);
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        }
        finally {

        }
        tp.iniciarTemporizador(3);
    }
}
