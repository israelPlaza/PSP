public class Hilo extends Thread{
    Registro registro;
    private int nombre;
    private String frase;

    public Hilo(int nombre, Registro registro){
        this.nombre = nombre;
        this.registro = registro;
    }
    @Override
    public void run(){
        frase ="soy el hilo "+String.valueOf(nombre);
        System.out.println(frase);
        registro.anadir(frase);
    }

}
