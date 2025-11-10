public class Puente {
    
    Vehiculo vehiculo;
    private int numero;
    private int cantidad=0;
    private int cola=0;

    public synchronized  void entrar(int numero) throws InterruptedException{
        System.out.println("vehiculo "+numero+" quiere entrar.");
        
        while (cantidad >1) { 
           cola++;
           System.out.println("vehiculo "+numero+" está en la cola ("+cola+")");
           wait();
           cola--;
        }
        cantidad++;
        System.out.println("vehiculo "+numero+" entra");

    }

    
    public synchronized  void salir(int numero){

        cantidad--;
        System.out.println("vehiculo "+numero+" sale del puente hay esprando "+cola);
        notifyAll();
        
    }

}
