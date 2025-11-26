public class Main {
    public static void main(String[] args) throws Exception {
        Puente puente = new Puente();
        int numero;
        Hilo hilo;

        for (int i = 0; i < 10; i++) {
            hilo= new Hilo(puente, i);
            hilo.start();
        }

    }
}
