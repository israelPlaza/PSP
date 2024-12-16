public class Main {
    public static void main(String[] args) throws InterruptedException {
        GestorDespegue gd = new GestorDespegue();
        System.out.println("Iniciando simulación");

        for (int i = 0; i < 10; i++) {
            if (Math.random() < 0.3) {
                new Avioneta(i, gd).start();
            } else {
                new Avion(i, gd).start();
            }
            Thread.sleep((long) (Math.random() * 1000));
        }
        
    }
}
