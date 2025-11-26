public class Main {
    public static void main(String[] args) throws Exception {
        GestorDespegue gestor = new GestorDespegue();
        Temporizador temporizador=new Temporizador(gestor);
        temporizador.start();
        Avion avion;
        Avioneta avioneta;
        boolean avionOavioneta;

        for (int i = 0; i < 10; i++) {
            avionOavioneta=(Math.random()>0.4);
            if (avionOavioneta) {
                avion =new Avion(gestor,temporizador);
                avion.start();
            }else if(avionOavioneta==false){
                avioneta = new Avioneta(gestor,temporizador);
                avioneta.start();
            }

            }

    }
}
