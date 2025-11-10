public class Persona extends Thread{
    
    private GestorMuseo gestorMuseo;
    private int numero;
    private TipoPersona tipoPersona;

    public Persona(GestorMuseo gestorMuseo,TipoPersona tipoPersona,int numero){
        this.gestorMuseo= gestorMuseo;
        this.tipoPersona=tipoPersona;
        this.numero=numero;
    }

    @Override
    public void run(){
        if (tipoPersona==TipoPersona.JUBILADO) {
            try {
                gestorMuseo.entrarSalaJubilado(numero);
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }else{
            try {
                gestorMuseo.entrarSala(numero);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        try {
            Thread.sleep(2000);
            gestorMuseo.salirSala(numero);
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }

    }


}
