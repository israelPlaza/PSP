package PracticaExamenMuseo;
enum vehiculo{NORTE,SUR,AMBULANCIA}

public class Vehiculos extends Thread{
    private GestorPuente gp;
    private vehiculo tipoVehiculo;

    public Vehiculos(GestorPuente gp,vehiculo tipoVehiculo){
        this.gp=gp;
        this.tipoVehiculo=tipoVehiculo;
    }
    public void run() {
        try {
            switch (tipoVehiculo) {
                case NORTE:
                    gp.entrarNorte();
                    break;
                case SUR:
                    gp.entraSur();
                    break;
                case AMBULANCIA:
                    gp.entraAmbulacia();
                    break;
            }
            // Simula el tiempo que tarda en cruzar
            Thread.sleep(1000);
            gp.salirPuente(); // Libera el puente al terminar
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
