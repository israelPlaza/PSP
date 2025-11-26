public class GestorDespegue {
    
    private Temporizador temporizador;
    private boolean pistaCerrada=false;
    private boolean avionetaAntes=false;
    private int esperaAviones;
    private boolean avion;
    private boolean avioneta;

    public GestorDespegue(){

    }

    public synchronized void despegarAvion() throws InterruptedException{
        System.out.println("Avión pide pista.");
        esperaAviones++;

        while (pistaCerrada==true) {
            wait();
        }
        pistaCerrada=true;
        esperaAviones--;
        avionetaAntes=false;
        this.avion=true;
        System.out.println("Avión despegando...");

    }

    public synchronized void despegarAvioneta() throws InterruptedException{
        System.out.println("Avioneta pide piesta.");

        while (pistaCerrada==true || avionetaAntes==true && esperaAviones>0) { 
            wait();
        }

        pistaCerrada=true;
        avionetaAntes=true;
        this.avioneta=true;
        System.out.println("Avioneta despegando...");
    }

    public synchronized void autorizarDespegue(boolean avion, boolean avioneta){
        System.out.println("Confirmación de pista libre.");
        pistaCerrada=false;
        this.avion=false;
        this.avioneta=false;
        notifyAll();
    }

}
