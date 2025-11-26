package Museo;

public class MainMuseo {
    public static void main(String[] args) throws InterruptedException {
        GestorSala gs = new GestorSala();
        gs.notificarTemperatura();
        Persona persona[] = new Persona[70];

        for (int i = 0; i < 70; i++) {
            double numAleatorio = Math.random();
            if (numAleatorio < 0.2) {
                persona[i] = new Persona(tipoPersona.Jubilado, gs);
            } else {
                persona[i] = new Persona(tipoPersona.Persona, gs);
            }
        }

        for (int i = 0; i < 70; i++) {
            persona[i].start();
        }

        for (int i = 0; i < 70; i++) {
            persona[i].join();
        }
    }
}
