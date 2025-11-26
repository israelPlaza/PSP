public class Puente {

    private int cochesIz;
    private int cochesDr;
    private boolean cocheEnPuente=false;


    public synchronized void llegar_al_puente(String sentido) throws InterruptedException{
        if ("izquierda".equals(sentido)){
            
            System.out.println("Coche intentando pasar por la izquieda");

            while( cocheEnPuente==true){
                wait();
            }
            System.out.println("Coche por la izquierda entrando");
        }

        if ("derecha".equals(sentido)){
            
            System.out.println("Coche intentando pasar por la derecha");

            while( cocheEnPuente==true){
                wait();
            }
            System.out.println("Coche por la derecha entrando");
        }
    }

    public synchronized void cruzar_puente(String sentido){
        if ("izquierda".equals(sentido)){
            cochesIz++;
            while (cochesIz>3) { 
                cocheEnPuente=true;
                System.out.println("Coche izquierda en puente, puden pasar: "+(cochesIz)+" más.");
            }
        }

        if ("derecha".equals(sentido)){
            cochesDr++;
            while (cochesDr>3) {
                cocheEnPuente=true;
                System.out.println("Coche derecha en puente, puden pasar: "+(cochesDr)+" más.");
            }
        }

    }

    public synchronized void salir_del_puente(String sentido){
        if ("izquierda".equals(sentido)){
            cochesIz--;
            if (cochesIz<100) {
                cocheEnPuente=false;
            }
            System.out.println("Coche por la izquierda saliendo...");
            notifyAll();
            
        }

        if ("derecha".equals(sentido)){
            cochesDr--;
            if (cochesDr<100) {
                cocheEnPuente=false;
            }
            System.out.println("Coche por la derecha saliendo...");
            notifyAll();
            
        }
    }

}
