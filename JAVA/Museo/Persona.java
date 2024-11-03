package Museo;
    enum tipoPersona{Persona,Jubilado}

public class Persona extends Thread{

    private GestorSala gs;
    private tipoPersona tipo;

    public Persona(tipoPersona tipo, GestorSala gs){
        this.tipo= tipo;
        this.gs= gs;

    }

    public void run(){
        if (tipo == tipoPersona.Persona) {
    try {
        gs.entrarSala();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
} else {
    try {
        gs.entrarSalaJubilado();
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}

        gs.salirSala();

    }

}

