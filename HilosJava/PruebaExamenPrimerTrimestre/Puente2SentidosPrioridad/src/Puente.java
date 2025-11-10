
public class Puente {
    
    Sentido sentido;
    Tipo tipo;
    private int capaciad=0;
    private int colaA;
    private int colaB;
    private int ambulaciasEsperandoA;
    private int ambulaciasEsperandoB;

    public Puente() {
        this.sentido = sentido;
        this.tipo = tipo;
        this.colaA =0;
        this.colaB =0;
        this.ambulaciasEsperandoA =0;
        this.ambulaciasEsperandoB =0;
    }
    
    public synchronized void entrarVehiculoA(int numero) throws InterruptedException{
        colaA++;
        System.out.println("vehículo "+numero+" quiere entrar");

        while (capaciad>2 || ambulaciasEsperandoA>0 
        || sentido==Sentido.B || colaA<colaB) { 
            wait();
        }

        capaciad++;
        sentido=Sentido.A;
        colaA--;
        System.out.println("vehículo "+numero+" entra en A ...esperado "+colaA);
    }

    public synchronized  void entrarAmbulaciaA(int numero) throws InterruptedException{

        ambulaciasEsperandoA++;
        System.out.println("Ambulancia "+numero+" esperando con prioridad");

        while (capaciad>2 || sentido==Sentido.B 
        || ambulaciasEsperandoA<ambulaciasEsperandoB) { 
            
            wait();
        }
        capaciad++;
        ambulaciasEsperandoA--;
        sentido=Sentido.A;
        System.out.println("Ambulacia entrado en A");
    }
    
    public synchronized void entrarVehiculoB(int numero) throws InterruptedException{
        colaB++;
        System.out.println("vehículo "+numero+" quiere entrar");

        while (capaciad>2 || ambulaciasEsperandoB>0 
        || sentido==Sentido.A || colaB<colaA) { 
            wait();
        }

        capaciad++;
        sentido=Sentido.B;
        colaB--;
        System.out.println("vehículo "+numero+" entra en B ...esperado "+colaB);
    }

    public synchronized  void entrarAmbulaciaB(int numero) throws InterruptedException{

        ambulaciasEsperandoB++;
        System.out.println("Ambulancia "+numero+" esperando con prioridad");

        while (capaciad>2 || sentido==Sentido.A
        || ambulaciasEsperandoB<ambulaciasEsperandoA) { 
            
            wait();
        }
        capaciad++;
        ambulaciasEsperandoB--;
        sentido=Sentido.B;
        System.out.println("Ambulacia entrado en B");
    }

    public synchronized void salir(int numero,Tipo tipo){
        if (tipo==Tipo.AMBULANCIA) {
            capaciad--;
            System.out.println("Ambulancia saliendo");
            if (capaciad==0) {
                sentido=Sentido.LIBRE;
            }
        }else{
            capaciad--;
            System.out.println("saliendo vehiculo");
            if (capaciad==0) {
                sentido=Sentido.LIBRE;
            }
        }
        notifyAll();


    }

}
