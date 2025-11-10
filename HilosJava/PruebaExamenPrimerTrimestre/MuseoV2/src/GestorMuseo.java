public class GestorMuseo {

    private Temperatura temperatura;
    private Persona persona;
    private int umbral=30;
    private int aforo;
    private int esperaPersona;
    private int esperaJubilado;
    private int maxAforo;

    public GestorMuseo(int maxAforo){
        this.maxAforo=maxAforo;
    }

    public synchronized void  entrarSala(int numero) throws InterruptedException{

        esperaPersona++;
        System.out.println("Persona "+numero+" espera a entrar");

        while (aforo>=maxAforo || esperaJubilado>0) { 
            wait();
        }

        aforo++;
        esperaPersona--;
        System.out.println("Persona "+numero+" en la sala, el aforo está "+aforo+" espera J"+esperaJubilado+" P "+esperaPersona);

    }

    public synchronized void  entrarSalaJubilado(int numero) throws InterruptedException{

        esperaJubilado++;
        System.out.println("Jubilado "+numero+" espera a entrar");

        while(aforo>=maxAforo){
            wait();
        }

        aforo++;
        esperaJubilado--;
        System.out.println("Jubilado "+numero+" en la sala, el aforo está "+aforo+" espera J"+esperaJubilado+" P "+esperaPersona);

    }

    public synchronized void  salirSala(int numero){

        aforo--;
        System.out.println("Persona "+numero+ " ha salido de la sala; aforo "+aforo);
        notifyAll();
    }

    public synchronized void  notificarTemperatura(int temperatura){
        if (temperatura >30) {
            maxAforo=35;
            System.out.println("se ha bajado el aforo por temperatura alta");
        }else{
            maxAforo=50;
            notifyAll();
        }
    }

}
