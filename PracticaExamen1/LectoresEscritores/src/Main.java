public class Main {
    public static void main(String[] args) throws Exception {
        BaseDatos bd = new BaseDatos();
        Escritor escritor;
        Lector lector;
        boolean aleatorio;

        for (int i = 0; i < 20; i++) {
            aleatorio=(Math.random()>0.5)?true:false;

            if (aleatorio) {
                escritor=new Escritor(i, bd);
                escritor.start();
            }else if (aleatorio==false) {
                lector= new Lector(i, bd);
                lector.start(); 
            }

        }

    }
}
