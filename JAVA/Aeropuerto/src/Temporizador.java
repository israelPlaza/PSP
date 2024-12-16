public class Temporizador extends Thread{
    private GestorDespegue gp;
    public Temporizador(GestorDespegue gp){
        this.gp=gp;
    }
    public void iniciarTemporizador(int minutos) throws InterruptedException {
        Thread.sleep(1000);
        gp.autorizarDespegue(minutos);
    }
}
