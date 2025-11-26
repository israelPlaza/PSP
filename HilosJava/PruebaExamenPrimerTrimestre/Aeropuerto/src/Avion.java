public class Avion extends Thread{
    private GestorDespegue gestor;
    private Temporizador temporizador;

    public Avion(GestorDespegue gestor,Temporizador temporizador){
        this.gestor=gestor;
        this.temporizador=temporizador;
    }

    @Override
    public void run(){
        try {
            gestor.despegarAvion();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            temporizador.iniciarTemporizador(0, true, false);
            gestor.autorizarDespegue(true, false);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
    }


}
