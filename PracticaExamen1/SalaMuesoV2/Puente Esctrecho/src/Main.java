public class Main {
    public static void main(String[] args) throws Exception {
        Puente puente = new  Puente();
        Coche coche;
        String sentido;

        for (int i = 0; i < 20; i++) {
            sentido = (Math.random()>0.5)?"izquierda":"derecha";
            coche=new Coche(sentido, puente);
            coche.start();
        }
    
    }
}
