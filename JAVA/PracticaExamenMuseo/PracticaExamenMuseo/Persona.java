package PracticaExamenMuseo.PracticaExamenMuseo;
enum tipoPersona{PERSONA,JUBILADO};
public class Persona extends Thread {

    private tipoPersona tipo;
    private GestorSala gs;

   public Persona(tipoPersona tipo, GestorSala gs){
       this.tipo=tipo;
       this.gs=gs;
   }

    @Override
    public void run() {
        if (tipo ==tipoPersona.PERSONA) {
            try {
                gs.entrarSala();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                gs.entrarSalaJubilado();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        gs.salirSala();
    }
}
