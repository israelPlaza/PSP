package PracticaExamenMuseo;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GestorPuente gp =new GestorPuente();
        Vehiculos vehiculos[]= new Vehiculos[10];
        double porcentaje;

        for(int i=0;i<10;i++){
           porcentaje=Math.random();
            if (porcentaje<0.2) {
                vehiculos[i]= new Vehiculos(gp, vehiculo.AMBULANCIA);
            } else if (porcentaje<0.6) {
                vehiculos[i]=new Vehiculos(gp,vehiculo.NORTE);
            }else
                vehiculos[i]=new Vehiculos(gp,vehiculo.SUR);
        }
        for (int i = 0; i < 10; i++) {
            vehiculos[i].start();
        }
        for (int i = 0; i < 10; i++) {
            vehiculos[i].join();
        }

    }
}
