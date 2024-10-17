public class Main {
public static void main(String[] args) {
    Hilo h1,h2;
    h1= new Hilo("hilo uno");
    h2 = new Hilo("hilo dos");

    h1.start();
    h2.start();
}
}
