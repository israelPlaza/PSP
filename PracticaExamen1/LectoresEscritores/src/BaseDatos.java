public class BaseDatos {
    private int numeroEscritor;
    private int lectoresLeyendo;
    private int lectoresEsperando;
    private int escritorEsperando;
    private boolean escritorDentro=false;

    public BaseDatos(){

    }

    public synchronized void lectura(int numeroLector) throws InterruptedException{
        lectoresEsperando++;
        System.out.println("lector "+numeroLector+ " queriendo entrar a BD");

        while (escritorDentro == true || lectoresLeyendo>2 || escritorEsperando>0) { 
            wait();
        }
        lectoresLeyendo++;
        lectoresEsperando--;
        System.out.println("Lector "+numeroLector+" leyendo en la BD.");

    }

    public  synchronized void escritura(int numeroEscritor) throws InterruptedException{
        escritorEsperando++;
        System.out.println("Escritor "+numeroEscritor+ " queriendo entrar a BD");

        while(escritorDentro==true || lectoresLeyendo>0){
            wait();
        }
        escritorEsperando--;
        escritorDentro=true;
        System.out.println("Escritor "+numeroEscritor+" Escribindo en la BD.");

    }


    public synchronized void salidaLector(int numeroLector){
        lectoresLeyendo--;
        System.out.println("Lector "+numeroLector+ " saliendo... quedan dentro: "+lectoresLeyendo);
        notifyAll();
    }

    public synchronized void saliendoEscritor(int numeroEscritor){
        escritorDentro=false;
        System.out.println("Escritor saliendo "+numeroEscritor+ " saliendo...");
        notifyAll();
    }

}
