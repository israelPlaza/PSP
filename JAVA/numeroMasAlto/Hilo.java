package numeroMasAlto;

public class Hilo extends Thread{
    private int id;
    private int apuesta;
    private int puntos;
    private Ring ring;

    public Hilo(int id,Ring ring){
        this.id=id;
        this.apuesta= (int) (Math.random()*10)+1;
        this.puntos=0;
        this.ring=ring;


    }

    public void run(){
        boolean ganar;
        try {

            do {
                try {
                    ring.entrar();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                ganar = ring.jugar(apuesta);
            } while (ganar);
        } catch (Exception e) {


        }
        }

}
