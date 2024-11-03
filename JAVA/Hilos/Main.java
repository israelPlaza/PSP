package Hilos;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int i;
        GestorPuente gestor = new GestorPuente();

        Vehiculo v[] = new Vehiculo[10];

        for (i = 0; i < 10; i++) {
            if (Math.random() < 0.5)
                v[i] = new Vehiculo(Acceso.NORTE, gestor);
            else
                v[i] = new Vehiculo(Acceso.SUR, gestor);
        }

        for (i = 0; i < 10; i++) {
            Thread.sleep((long) (Math.random() * 2000));
            v[i].start();
        }
    }
}
