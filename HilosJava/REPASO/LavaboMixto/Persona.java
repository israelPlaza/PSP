package LavaboMixto;
enum persona {hombre,mujer}
public class Persona extends Thread {
    private GestorLavabo gl;
    private persona tipo;

    public Persona(GestorLavabo gl, persona tipo) {
        this.gl = gl;
        this.tipo = tipo;
    }

    public void run() {
        if (tipo == persona.hombre) {

            try {
                gl.entrarHombre();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gl.salirHombre();
        } else if (tipo == persona.mujer) {
            try {
                gl.entraMujer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            gl.salirMujer();
        }

    }
}
