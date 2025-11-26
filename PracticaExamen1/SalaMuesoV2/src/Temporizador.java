public class Temporizador extends  Thread{
    private GestorSala gestor;
    private int temperatura = 28;
    private boolean fin = false;

    public Temporizador(GestorSala gestor){
        this.gestor=gestor;
    }

    @Override
    public void  run(){
        while (!fin) { 
        temperatura = (int)(Math.random()*30) +15;
        gestor.notificarTemperatura(temperatura);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        }

    }

    public  void fin(){
        fin=true;
    }

}
