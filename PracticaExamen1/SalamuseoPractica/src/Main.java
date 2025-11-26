public class Main {
    public static void main(String[] args) throws Exception {
        GestorSala gestor =new GestorSala(50);
        SensorTemperatura sensor = new SensorTemperatura(gestor);
        sensor.start();
        
        Personas personas;
        TipoPersona tipoPersona;
        

        for (int i = 0; i < 100; i++) {
            tipoPersona=(Math.random()>0.8)?TipoPersona.JUBILADO :TipoPersona.PERSONA;
            personas = new Personas(i, gestor, tipoPersona);
            personas.start();

        }

    }
}
