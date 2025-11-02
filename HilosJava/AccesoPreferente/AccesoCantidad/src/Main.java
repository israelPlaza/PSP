public class Main {
    public static void main(String[] args) throws Exception {
    
        Puente puente = new  Puente();
        Vehiculo vehiculo;
        for (int i = 0; i < 10; i++) {
            vehiculo =new  Vehiculo(i, puente);
            vehiculo.start();
        }
    
    }
}
