public class Temperatura extends Thread {
    private GestorSala gestorSala;
    private int temperatura;
    private boolean fin;

    public Temperatura(GestorSala gestorSala){
        this.gestorSala=gestorSala;
        this.temperatura=25;
        this.fin=false;
    
    }

    @Override
    public void run(){
        while (!fin) { 
            //temperatura+= Math.random()*5-2;
            gestorSala.notificarTEmperatura(temperatura);

        }
    }

    public void terminaSensor(){
        this.fin=true;
    }

}
