public class Main {
public static void main(String[] args) throws InterruptedException {
    
    Hilo[] hilos= new Hilo[3];

    for (int i = 0; i < hilos.length; i++) {
        hilos[i] = new Hilo(i);
        hilos[i].start();
        Thread.sleep(1000);
        try {
            hilos[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println("Fin del programa");

}
}
