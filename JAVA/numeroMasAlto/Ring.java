package numeroMasAlto;

public class Ring {
    private int nJugadoresEsperando=0;
    private int nJugadoresDentro=0;
    private boolean abierto=true;
    private  int  nJugadoresJugando=0;
    private int apuestaContrario;
    private boolean resultadoContario;
    public synchronized void entrar() throws InterruptedException {
        nJugadoresEsperando++;
        System.out.println("Nuevo jugador esparendo"+ nJugadoresEsperando);
        while (nJugadoresEsperando < 2 || abierto==false) {
            wait();
            nJugadoresDentro++;
            if (nJugadoresDentro==2){
                abierto=false;
            }

        }
    }
    public synchronized boolean jugar(int apuesta) throws InterruptedException {
        boolean resultado;
        nJugadoresJugando++;

        if(nJugadoresJugando==1){
            apuestaContrario= apuesta;
            System.out.println("la puesta del primero es " +apuestaContrario);
            wait();
            resultado=resultadoContario;
        }else{
            if (apuesta>=apuestaContrario){

                resultadoContario=false;
                resultado=true;
            }else {
                resultadoContario=true;
                resultado=false;
            }
            notifyAll();
        }
        nJugadoresJugando--;
        if (nJugadoresDentro==2){
            System.out.println("ya tenenos los dos jugadores");
            abierto=false;
            nJugadoresDentro=0;
            nJugadoresJugando-=2;
            System.out.println("salaen los dos");
            notifyAll();
        }
        return resultado;
    }
}
