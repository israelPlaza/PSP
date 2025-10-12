public class Main {
    public static void main(String[] args) throws InterruptedException {

        Registro registro = new Registro();
        Hilo[] hilos = new Hilo[6];

        for (int i = 0; i < hilos.length; i++) {

            hilos[i] =new Hilo(i,registro);
            hilos[i].start();
            
        }

        for (int i = 0; i < hilos.length; i++) {
            hilos[i].join();
        }

        System.out.println(registro.getNombreHilos());
    }
}
