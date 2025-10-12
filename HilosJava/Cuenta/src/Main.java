public class Main {
    public static void main(String[] args) throws InterruptedException {

        Banco banco = new Banco();
        Hilo[] hilos = new Hilo[3];

        for (int i = 0; i < hilos.length; i++) {

            hilos[i] = new Hilo(banco, i);
            hilos[i].start();
        
        }

        for (int i = 0; i < hilos.length; i++) {

            hilos[i].join();
        }

        System.out.println("Queda un total: " +banco.getSaldo());
        System.out.println("Fin Main...");

    }
}
