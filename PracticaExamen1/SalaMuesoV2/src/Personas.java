public class Personas extends Thread{
    private GestorSala gestor;
    private int numero;
    private TipoPersona tipo;

    public Personas(int numero,GestorSala gestor, TipoPersona tipo){
        this.tipo=tipo;
        this.gestor=gestor;
        this.numero=numero;
    }

    @Override
    public void run(){
        if (tipo==TipoPersona.USUARIO) {
            try {
                gestor.entrarSalaPersona(numero);
                Thread.sleep(2000);
                gestor.salirSala();
            } catch (InterruptedException ex) {
            }

        } if(tipo==TipoPersona.JUBILADO){
          try {
            gestor.entrarSalaJubilado(numero);
            Thread.sleep(3000);
            gestor.salirSala();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }
    }

}
