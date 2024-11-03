package Hilos;
enum Acceso{NORTE,SUR, AMBULANCIA}
public class Vehiculo extends Thread {

    private Acceso acceso;
    private GestorPuente gp;

    public Vehiculo (Acceso acceso,GestorPuente gp)
    {
        this.acceso = acceso;
        this.gp = gp;
    }

    public void run()
    {

        try
        {
            if (acceso==Acceso.NORTE)
                gp.entrarNorte();
            else
                gp.entrarSur();

            sleep (2000);
        } catch (InterruptedException e) {e.printStackTrace();}

        gp.salirPuente();
    }
}
