public class GestorSala {
    private  SensorTemperatura sensor;
    private int aforo=0;
    private  int personasSala;
    private int jubiladosEsperando;
    private int personasEsperando;
    private int temperatura;
    private int numero;
    private Personas persona;
    private TipoPersona tipoP;


    public GestorSala(int aforo){
        this.aforo=aforo;
    }

    public synchronized void entrarSala(int numero) throws InterruptedException{
        personasEsperando++;
        System.out.println("Persona "+numero+" quiere entrar.");

        while (jubiladosEsperando>0 || personasSala>=aforo) { 
            wait();
        }
        personasEsperando--;
        personasSala++;
        System.out.println("Persona "+numero+" ha entrado, el aforo es:"
        +aforo+" P: "+personasEsperando+" J: "+jubiladosEsperando);


    }

    public synchronized void entrarSalaJubilado(int numero) throws InterruptedException{
        jubiladosEsperando++;
        System.out.println("Jubilado "+numero+" quiere entrar.");

        while (personasSala>=aforo) { 
            wait();
        }
        jubiladosEsperando--;
        personasSala++;
        System.out.println("Jubilado "+numero+" ha entrado, el aforo es:"
        +aforo+" P: "+personasEsperando+" J: "+jubiladosEsperando);

    }

    public synchronized void salirSala(int numero, TipoPersona tipoPersona){
        
            personasSala--;
            System.out.println("Persona "+numero+" ha salido. peronas en sala:"+personasSala);
            notifyAll();
    
    }

    public synchronized void notificarTemperatura(int temperatura){
        System.out.println("midiendo temperatura... Temperatura es: "+temperatura);
        if (temperatura>30) {
            System.out.println("aforo a 35 por temperatura elevada");
            aforo=35;
            
        }else if(temperatura<=30){
            aforo=50;
        }


    }

}
