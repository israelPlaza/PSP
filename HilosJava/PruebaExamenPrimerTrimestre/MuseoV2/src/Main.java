import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        GestorMuseo gestorMuseo=new GestorMuseo(50);
        Persona persona;
        TipoPersona tipoPersona;
        ArrayList<Persona> personas= new ArrayList<>();
        Temperatura temperatura= new Temperatura(gestorMuseo, 0);
        temperatura.start();

        for (int i = 0; i < 100; i++) {
            
            tipoPersona=(Math.random()>0.8)?TipoPersona.JUBILADO:TipoPersona.PERSONA;
            persona= new Persona(gestorMuseo, tipoPersona, i);
            personas.add(persona);
            persona.start();
        }

        for (Persona persona2 : personas) {
            persona2.join();
        }
        temperatura.terminar();


    }
}
