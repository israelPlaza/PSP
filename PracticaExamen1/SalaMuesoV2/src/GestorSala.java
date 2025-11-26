public class GestorSala {

private Temporizador temporizador;
private int esperaPersona;
private int esperaJubilado;
private  int aforo;
private int personasEnSala;

    public GestorSala(int aforo){
        this.aforo=aforo;
    }

    public synchronized void entrarSalaPersona(int numero) throws InterruptedException{
        System.out.println("Usuario "+numero+" quiere entrar.");
        esperaPersona++;

        while (personasEnSala>=aforo ||esperaJubilado>0 ) { 
            wait();
        }

        esperaPersona--;
        personasEnSala++;
        System.err.println("Usuario "+numero+" ha entrado, aforo: "+ personasEnSala
        +" hay U:"+esperaPersona+" J:"+esperaJubilado);

    }

    public synchronized void entrarSalaJubilado(int numero) throws InterruptedException{
        System.out.println("Jubilado "+numero+" quiere entra.");
        esperaJubilado++;
        
        while (personasEnSala>=aforo) { 
            wait();
        }

        esperaJubilado--;
        personasEnSala++;
        System.err.println("Jubialdo "+numero+" ha entrado, aforo: "+ personasEnSala
        +" hay esperando U:"+esperaPersona+" J:"+esperaJubilado);

    }

    public synchronized void salirSala(){
        personasEnSala--;
        System.out.println("Persona saliendo... puden entrar "+(aforo - personasEnSala)+"/"+aforo);
        notifyAll();
    }

    public synchronized void notificarTemperatura(int temperatura){
        if (temperatura>35) {
            System.out.println("Temperatura eleveda se baja el aforo a 35 personas");
            aforo=35;
        } else if(temperatura<=35) {
            aforo=50;
            System.out.println("Aforo a 50 personas");
        }
        }

}
