package PracticaExamenMuseo.PracticaExamenMuseo;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        GestorSala  gs= new GestorSala();
        Persona[] personas =new Persona[50] ;

        for (int i = 0; i < 50; i++) {
           double aleatorio= Math.random();
            if (aleatorio<0.4) {
                personas[i]= new Persona(tipoPersona.JUBILADO,gs);

            }else {
                personas[i]=new Persona(tipoPersona.PERSONA,gs);
            }
        }
        for (int i = 0; i < 50; i++) {
            personas[i].start();
        }
        for (int i = 0; i < 50; i++) {
            personas[i].join();
        }


    }
}
