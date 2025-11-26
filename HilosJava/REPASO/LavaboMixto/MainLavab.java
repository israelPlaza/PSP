package LavaboMixto;

public class MainLavab {
    public static void main(String[] args) throws InterruptedException {
        int capacidad=4;
        GestorLavabo gl = new GestorLavabo(capacidad);
        Persona persona[] =new Persona[20];

        for (int i = 0; i < 20; i++) {
            double aleatorioSexo= Math.random();
            if (aleatorioSexo<5.0){
                persona[i] =new Persona(gl, LavaboMixto.persona.hombre);
            }else {
                persona[i] =new Persona(gl,LavaboMixto.persona.mujer);
            }
        }
        for (int i = 0; i < 20; i++) {
            persona[i].start();

        }
        for (int i = 0; i < 20; i++) {
            persona[i].join();
        }

    }
}
