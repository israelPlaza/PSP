package PracticaExamenMuseo;

public class GestorPuente {
    private boolean puenteOcupado;
    private int esperanNorte;
    private int esperanSur;
    private int esperanAmbulancias;

    public GestorPuente(boolean puenteOcupado, int esperanNorte, int esperanSur, int esperanAmbulancias) {
        this.puenteOcupado = puenteOcupado=false;
        this.esperanNorte = esperanNorte;
        this.esperanSur = esperanSur;
        this.esperanAmbulancias = esperanAmbulancias;
    }

    public GestorPuente() {

    }

    public synchronized void entrarNorte() throws InterruptedException {
        esperanNorte++;
        System.out.println("Vehículos esperando en el norte "+ esperanNorte);
        while (puenteOcupado || esperanNorte>esperanSur ||esperanAmbulancias>0){
            wait();
        }
        esperanNorte--;
        System.out.println("Vehículos entrando por el norte");
        puenteOcupado=true;
    }
    public synchronized void entraSur() throws InterruptedException {
        esperanSur++;
        System.out.println("Vehículos esperando por el sur "+esperanSur);
        while (puenteOcupado||esperanSur>esperanNorte || esperanAmbulancias>0){
            wait();
        }
        esperanSur--;
        System.out.println("Vehículo entrando por el sur");
        puenteOcupado=true;
    }
    public synchronized void entraAmbulacia() throws InterruptedException {
        esperanAmbulancias++;
        System.out.println("Ambulacias esperando " + esperanAmbulancias);
        while (puenteOcupado){
           wait();
        }
        esperanAmbulancias--;
        System.out.println("Ambulancia entrando");
    }
    public synchronized void salirPuente(){
        System.out.println("saliendo del puente");
        puenteOcupado=false;
        notifyAll();
    }
}
