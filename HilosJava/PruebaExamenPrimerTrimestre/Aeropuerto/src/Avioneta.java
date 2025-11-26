public class Avioneta extends Thread{
    private GestorDespegue gestor;
    private Temporizador temporizador;
    
    public Avioneta(GestorDespegue gestor,Temporizador temporizador){
        this.gestor=gestor;
        this.temporizador=temporizador;
    }

    @Override
    public void run(){
        try {
            gestor.despegarAvioneta();
            temporizador.iniciarTemporizador(0, false, true);
            gestor.autorizarDespegue(false, true);

        } catch (InterruptedException e) {
            e.printStackTrace();
            
        }
    }
}
