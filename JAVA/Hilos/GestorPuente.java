package Hilos;

public class GestorPuente {
    private boolean puenteOcupado;
    private int esperanNorte;
    private int esperanSur;
    private int getEsperanAmbulancias;

    public void GestorPuente()
    {
        puenteOcupado = false;
        esperanNorte=0;
        esperanSur=0;
    }
    public synchronized void entrarNorte() throws InterruptedException
    {
        esperanNorte++;
        System.out.println("Vehiculo llega norte. Esperando en Norte:"+esperanNorte);
        while (puenteOcupado || esperanNorte<esperanSur)
            wait();
        esperanNorte--;
        puenteOcupado=true;
        System.out.println("Vehiculo Norte entra en puente");
    }

    public synchronized void entrarSur() throws InterruptedException
    {
        esperanSur++;
        System.out.println("Vehiculo llega sur. Esperando en Sur:"+esperanSur);
        while (puenteOcupado || esperanSur<esperanNorte)
            wait();
        esperanSur--;
        puenteOcupado=true;
        System.out.println("Vehiculo Sur entra en puente");
    }

    public synchronized  void   entrarAmbulacia(){

    }

    public void entrarAmbulancia() throws InterruptedException {
        getEsperanAmbulancias++;
        while (puenteOcupado){
            wait();
            getEsperanAmbulancias--;
            System.out.println("Entra a");
            puenteOcupado=true;

        }
    }

    public synchronized  void salirPuente()
    {
        puenteOcupado=false;
        notifyAll();
        System.out.println("Vehículo sale del puente");
    }

}
