public class Persona extends Thread{
    private GestorSala gestorSala;
    private int numero;
    private TipoPersona tipoPersona;


    public Persona(GestorSala gestorSala, TipoPersona tipoPersona, int numero){
        this.gestorSala=gestorSala;
        this.numero=numero;
        this.tipoPersona=tipoPersona;
    }

    @Override
    public void run(){
        if (tipoPersona==TipoPersona.JUBILADO) {
            try {
                gestorSala.entrarSalaJubilado(numero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            try {
                gestorSala.entrarSala(numero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(300);
            gestorSala.salirSala(numero);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
