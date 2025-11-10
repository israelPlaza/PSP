public class Main {
    public static void main(String[] args){
        Puente puente =new Puente();
        Vehiculo vehiculo;

        for (int i = 0; i < 20; i++) {
            vehiculo=new Vehiculo(i, puente);
            vehiculo.start();
        }


    }
}
