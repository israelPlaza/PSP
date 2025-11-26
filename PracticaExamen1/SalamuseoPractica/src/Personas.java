public class Personas extends Thread{
    private TipoPersona tipoPersona;
    private int numero;
    private GestorSala gestor;

    public Personas(int numero, GestorSala gestor, TipoPersona tipoPersona){
        this.numero=numero;
        this.gestor=gestor;
        this.tipoPersona=tipoPersona;

    }

    @Override
    public void run(){
        if (tipoPersona==TipoPersona.PERSONA) {
            try {
                gestor.entrarSala(this.numero);
                Thread.sleep(2000);
                gestor.salirSala(this.numero,this.tipoPersona);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (tipoPersona==TipoPersona.JUBILADO){
            try {
                gestor.entrarSalaJubilado(this.numero);
                Thread.sleep(3000);
                gestor.salirSala(this.numero,this.tipoPersona);
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
        }

    }

}
