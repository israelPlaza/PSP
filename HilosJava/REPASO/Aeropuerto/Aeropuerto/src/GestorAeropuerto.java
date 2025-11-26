public class GestorAeropuerto {
    private boolean pistaCerrada;
    private int nAvionesEsperando;
    private boolean avionetaAnterior;

    public GestorAeropuerto(){
        this.pistaCerrada = false;
        this.nAvionesEsperando = 0;
        this.avionetaAnterior = false;
    }

    public synchronized void despegarAvion(int identificador) throws InterruptedException {
        System.out.println("Avion " + identificador + " solicita pista");
        nAvionesEsperando++;
        while (pistaCerrada) {
            wait();
        }
        pistaCerrada = true;
        nAvionesEsperando--;
        avionetaAnterior = false;
        System.out.println("Despega un avion");
    }

    public synchronized void despegarAvioneta(int identificador) throws InterruptedException {
        System.out.println("Avioneta " + identificador + " solicita pista");
        while (pistaCerrada || (nAvionesEsperando > 0 && avionetaAnterior)) {
            wait();
        }
        pistaCerrada = true;
        avionetaAnterior = true;
        System.out.println("Despega una avioneta");
    }

    public synchronized void autorizarDespegue() {
        pistaCerrada = false;
        notifyAll();
    }
}
