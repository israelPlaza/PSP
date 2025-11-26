public class Avioneta extends Thread {
    private int identificador;
    private GestorAeropuerto ga;
    private Temporizador tp;
    public Avioneta(int identificador,GestorAeropuerto ga, Temporizador tp){
        this.ga=ga;
        this.identificador=identificador;
        this.tp =tp;
    }
    public void run(){
        try {
            ga.despegarAvioneta(identificador);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        tp.iniciarTemporizador(2);
    }
}

