
public class Vehiculo extends Thread{

private Puente puente;
private Tipo tipo;
private  int numero;

    public Vehiculo(int numero, Puente puente, Tipo tipo){
        this.numero=numero;
        this.puente=puente;
        this.tipo=tipo;
    }

    @Override
    public void  run(){
        if (this.tipo ==Tipo.COCHE) {
            try {
                puente.entradaCoche(numero);
                Thread.sleep(2000);
                puente.salidaCoche(numero);
            } catch (InterruptedException ex) {
            }
        }else if(this.tipo==Tipo.AMBULANCIA){
            try {
                puente.entradaAmbulancia(numero);
                Thread.sleep(2000);
                puente.salidaAmbulancia(numero);
            } catch (InterruptedException ex) {
            }
        }

    }


}
