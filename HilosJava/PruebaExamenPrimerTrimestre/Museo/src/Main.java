import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        GestorSala gestorSala= new GestorSala(5);
        Temperatura temperatura=new Temperatura(gestorSala);
        Persona persona;
        ArrayList<Persona> personas = new ArrayList<>();
        TipoPersona tipoPersona;
        temperatura.start();
        
        for (int i = 0; i < 100; i++) {
            tipoPersona= (Math.random()>0.7)?TipoPersona.JUBILADO:TipoPersona.PERSONA;
            persona=new Persona(gestorSala, tipoPersona, i);
            personas.add(persona);
            persona.start();

        }

        for (Persona p : personas) {
            p.join();
            
        }
        temperatura.terminaSensor();


    }
}
