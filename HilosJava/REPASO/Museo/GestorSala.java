package Museo;

public class GestorSala {

    private int conteoPersona;
    private MedidoTemperatura mt;
    private int jubiladosEsperando=0;
    public GestorSala() {
        this.mt = new MedidoTemperatura();
    }

    public synchronized void entrarSala() throws InterruptedException {
        while (conteoPersona >= 50 || (mt.getTemperatura() > 30 && conteoPersona >= 35) || jubiladosEsperando>0) {
            wait();
        }
        conteoPersona++;
        System.out.println("Entra una persona " + conteoPersona);

    }

    public synchronized void entrarSalaJubilado() throws InterruptedException {
        jubiladosEsperando++;
        while (conteoPersona >= 50 || (mt.getTemperatura() > 30 && conteoPersona >= 35)) {
            wait();
        }
        jubiladosEsperando--;
        conteoPersona++;
        System.out.println("Entra una persona jubilada " + conteoPersona);

    }

    public synchronized void salirSala() {

        if (conteoPersona>15){
            notificarTemperatura();
        }
        conteoPersona--;
        System.out.println("Sale persona de la sala, quedan " + conteoPersona);
        notifyAll();
    }

    public void notificarTemperatura() {
        mt.escribirTemperatura();
        mt.mostrarTemperatura();
    }
}
