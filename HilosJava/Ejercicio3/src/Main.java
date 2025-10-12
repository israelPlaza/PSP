public class Main {
    public static void main(String[] args) throws Exception {
        Hilo[] hilos = new Hilo[5];

    for (int i = 0; i < hilos.length; i++) {
        hilos[i] = new Hilo(i);
        hilos[i].start();
    }

    }
}
