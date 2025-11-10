public class Vehiculo extends Thread{

    private Puente puente;
    private int numero;
    private Sentido sentido;
    private Tipo tipo;
    
    public Vehiculo(Puente puente, int numero, Sentido sentido, Tipo tipo) {
        this.puente = puente;
        this.numero = numero;
        this.sentido = sentido;
        this.tipo = tipo;
    }

    @Override
    public void run(){
    try {
        if (this.tipo==Tipo.AMBULANCIA && this.sentido==Sentido.A) {
            
                puente.entrarAmbulaciaA(numero);
            
        }if (this.tipo==Tipo.AMBULANCIA && this.sentido==Sentido.B) {
            
            puente.entrarAmbulaciaB(numero);
        }if(this.tipo==Tipo.VEHICULO && this.sentido==Sentido.A){

            puente.entrarVehiculoA(numero);
        }if(this.tipo==Tipo.VEHICULO && this.sentido==Sentido.B){

            puente.entrarVehiculoB(numero);
        }
    } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        puente.salir(numero, tipo);
    }

}
