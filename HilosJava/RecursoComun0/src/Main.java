public class Main {
public static void main(String[] args) throws InterruptedException {
    Contador contador = new Contador();
    Hilo[] hilos =new Hilo[3];

    for (int i = 0; i < hilos.length; i++) {
        hilos[i] = new Hilo(i,contador);
        hilos[i].start();
        /* try {
            hilos[i].join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } */

    }
    hilos[2].join();
    System.out.println("El contador es " +contador.getValor());
    System.out.println("Fin main");

}
}
