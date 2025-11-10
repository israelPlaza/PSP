public class Main {
    public static void main(String[] args) throws Exception {
        
        Sentido sentido;
        Vehiculo vehiculo;
        Puente puente = new  Puente();

        for (int i = 0; i < 15; i++) {
            sentido=(Math.random()>=0.5)?Sentido.A:Sentido.B;
            vehiculo = new  Vehiculo(puente, sentido, i);
            vehiculo.start();
        }
    
    
    }
}