
public class Main {
public static void main(String[] args) {
    int numero;
    Hilo h1 = new Hilo(1);
    Hilo h2 = new Hilo(2);

    h1.start();
    h2.start();
    System.out.println("Fin hilo principal");


}
}
