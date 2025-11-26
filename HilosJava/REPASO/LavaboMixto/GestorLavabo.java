package LavaboMixto;

public class GestorLavabo {

    private int capacidad=4;
    private int personasEnBano = 0;
    private int hombresEsperando = 0;
    private int mujeresEsperando = 0;
    private boolean mujeresDentro = false;
    private boolean hombresDentro = false;

    public GestorLavabo(int capacidad) {
        this.capacidad = capacidad;
    }

    public  synchronized void entrarHombre() throws InterruptedException {
        hombresEsperando ++;
        System.out.println("Hay "+hombresEsperando+ " hombres y hay "+personasEnBano+" perosnas dentro.");
        while (mujeresDentro || personasEnBano>=capacidad){
            wait();
        }
        hombresEsperando--;
        hombresDentro=true;
        personasEnBano++;
    }

    public synchronized void salirHombre(){
        System.out.println("Hay "+personasEnBano);
        personasEnBano--;
        if (personasEnBano==0){
            hombresDentro=false;
            notifyAll();
        } else if (hombresEsperando>0 && personasEnBano< capacidad) {
            notifyAll();
        }
    }

    public synchronized void entraMujer() throws InterruptedException {
        mujeresEsperando++;
        System.out.println("Hay "+mujeresEsperando+ " mujeres esperando y hay "+personasEnBano+" personas dentro.");
        while (hombresDentro || personasEnBano>=capacidad){
            wait();
        }
        mujeresEsperando--;
        mujeresDentro=true;
        personasEnBano++;
    }

    public synchronized void salirMujer(){
        personasEnBano--;
        if (personasEnBano==0){
            mujeresDentro=false;
            notifyAll();
        } else if (mujeresEsperando>0 && personasEnBano<capacidad) {
            notifyAll();
        }
    }

}
