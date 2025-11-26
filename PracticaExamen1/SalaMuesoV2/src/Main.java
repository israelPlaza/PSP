public class Main {
    public static void main(String[] args) throws Exception {
        int aforo=50;
        GestorSala gestor = new  GestorSala(aforo);
        Personas persona;
        TipoPersona tipo;
        Temporizador temperorizador = new Temporizador(gestor);
        temperorizador.start();

        for (int i = 0; i < 100; i++) {
            tipo=(Math.random()>0.8)?TipoPersona.JUBILADO:TipoPersona.USUARIO;
            persona=new Personas(i, gestor, tipo); 
            persona.start();
        }

    }
}
