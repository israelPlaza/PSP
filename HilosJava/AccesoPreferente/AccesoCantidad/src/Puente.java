public class Puente {

    private int cantidad=0;
    private final int MAX_VEHICULOS = 2;
    public Puente(){
        
    }

    public synchronized void entrar(int numero) throws InterruptedException {
        
        System.out.println("vehiculo "+numero+" quiere entrar");
        while (cantidad == MAX_VEHICULOS) { 
            wait();
        }
        cantidad++;
        System.out.println("vehículo " +numero+" ha entrado "+cantidad);
       
    }

    public synchronized  void salida(int numero){
        System.out.println("vehículo "+numero+" ha salido -"+cantidad);
        cantidad--;
        notifyAll();
    }
}