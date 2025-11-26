

public class Temporizador extends Thread{
    private GestorDespegue gestor;
    
    

    public Temporizador(GestorDespegue gestor ){
        this.gestor=gestor;
        
    }

    public void iniciarTemporizador(int minutos, boolean avion, boolean avioneta) throws InterruptedException{
        
        if (avion) {
            Thread.sleep(3000);
        }else if(avioneta){
            Thread.sleep(2000);
        }
        

    }

}
