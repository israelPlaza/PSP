public class Puente {
private int esperandoCoches;
private int esperandoAmbulancias;
private boolean dentroDelPuente=false;


    public  Puente(){
    

    }

    public synchronized  void  entradaCoche(int numero) throws InterruptedException{
        esperandoCoches++;
        System.out.println("Coche "+numero+" quiere entrar"
        +" esperando: "+esperandoCoches);

        while (dentroDelPuente==true || esperandoAmbulancias>0) { 
            wait();

        }

        System.out.println("Coche "+numero+" en el puente...");
        dentroDelPuente = true;
    }

    public synchronized  void  entradaAmbulancia(int numero) throws InterruptedException{
        esperandoAmbulancias++;
        System.out.println("Ambulancia "+numero+" quiere entrar"
        +" esperando: "+esperandoAmbulancias);

        while (dentroDelPuente==true) { 
            wait();
        }

        System.out.println("Ambulancia "+numero+" en el puente...");
        dentroDelPuente = true;
    }

    public synchronized void salidaCoche(int numero){
        esperandoCoches--;
        System.out.println("Coche "+numero+" saliendo "
        +"esperando Coches: "+esperandoCoches+", ambulancias: "+esperandoAmbulancias);
        dentroDelPuente=false;
        notifyAll();
    }

    public synchronized void salidaAmbulancia(int numero){
        esperandoAmbulancias--;
        System.out.println("Ambulancia "+numero+" saliendo "
        +"esperando Coches: "+esperandoCoches+", ambulancias: "+esperandoAmbulancias);
        dentroDelPuente=false;
        notifyAll();
    }


}
