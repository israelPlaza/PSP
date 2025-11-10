public class Temperatura extends Thread{

    private GestorMuseo gestorMuseo;
    private int temperatura;
    private boolean fin;

    public Temperatura(GestorMuseo gestorMuseo, int temperatura){
        this.gestorMuseo=gestorMuseo;
        this.temperatura=temperatura;
    }

    @Override
    public void run(){

        while (!fin) { 
            
        temperatura += Math.random()*5-2;
			gestorMuseo.notificarTemperatura(temperatura);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
               
                e.printStackTrace();
            }
        }

    }

    public void terminar()
	{
		this.fin = true;
	}


}
