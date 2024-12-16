public class Avioneta extends Thread {
    private final int identificador;
    private final GestorDespegue gd;

    public Avioneta(int identificador, GestorDespegue gd) {
        this.identificador = identificador;
        this.gd = gd;
    }

    @Override
    public void run() {
        try {
            gd.despegarAvioneta(identificador);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}