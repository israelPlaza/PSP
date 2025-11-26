package Museo;
    enum tipoPersona{Persona,Jubilado}

public class Persona extends Thread{

    private GestorSala gs;
    private tipoPersona tipo;

    public Persona(tipoPersona tipo, GestorSala gs){
        this.tipo= tipo;
        this.gs= gs;

    }
    public void run() {
        try {
            if (tipo == tipoPersona.Persona) {
                gs.entrarSala();
            } else {
                gs.entrarSalaJubilado();
            }
            gs.salirSala();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}

