public class Main {
    public static void main(String[] args) throws Exception {
        Tipo tipo;
        Puente puente = new Puente();
        Vehiculo vehiculo;

        for (int i = 0; i < 15; i++) {
            tipo =(Math.random()>=0.7)?Tipo.AMBULANCIA:Tipo.COCHE;
            vehiculo= new Vehiculo(i, puente, tipo);
            vehiculo.start();    

        }

}
}