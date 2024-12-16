public class Avion extends Thread {
    private final int identificador;
    private final GestorDespegue gd;

    public Avion(int identificador, GestorDespegue gd) {
        this.identificador = identificador;
        this.gd = gd;
    }

    @Override
    public void run() {
        try {
            gd.despegarAvion(identificador);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}