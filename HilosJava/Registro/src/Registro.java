
import java.util.ArrayList;

public class Registro {

    ArrayList<String> nombreHilos= new ArrayList<>();

    public Registro(){

    }

    public synchronized   void anadir(String nombre){
        nombreHilos.add(nombre);
    }

    public ArrayList<String> getNombreHilos() {
        return nombreHilos;
    }


}
