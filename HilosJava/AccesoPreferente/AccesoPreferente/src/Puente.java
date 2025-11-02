public class Puente {
    
    private  boolean ocupado;
    
    public  Puente(){
        this.ocupado = false;

    }

    public synchronized void entrada(int numero) throws InterruptedException{

        System.out.println("El vehículo "+numero+" quiere entrar");
        while (this.ocupado) { 
            wait();
        }

        this.ocupado= true;
        System.out.println("vehículo "+numero+" entra");
        
    }

    public synchronized  void salida(int numero){
        
        System.out.println("El vehiculo "+numero+" sale");
        this.ocupado=false;
        notifyAll();


    }




}
