public class Aeropuerto {
    private int esperaAviones;
    private boolean avionetasAnterior;
    private boolean pistaCerrada;

    public Aeropuerto(){

    }

    public synchronized void despegueAvion(){
        esperaAviones++;
        System.out.println("Avión queriendo pide pista para despegar.");

        while (pistaCerrada==true || ) {
            
        }

    }

    public synchronized void despegueAvioneta(){
        
    }

    public synchronized void autorizarDespegue(){
        
    }

}
