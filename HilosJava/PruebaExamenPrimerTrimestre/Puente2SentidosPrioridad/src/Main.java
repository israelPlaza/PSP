public class Main {
    public static void main(String[] args) throws Exception {
    Puente puente = new Puente();
    Vehiculo vehiculo;
    Sentido sentido;
    Tipo tipo;
    
    for (int i = 0; i < 10; i++) {
        sentido=(Math.random()>=0.5)?Sentido.A:Sentido.B;
        tipo=(Math.random()<=0.3)?Tipo.AMBULANCIA:Tipo.VEHICULO;
        vehiculo = new Vehiculo(puente, i, sentido, tipo);
        vehiculo.start();
    }
    
    
    }
}
