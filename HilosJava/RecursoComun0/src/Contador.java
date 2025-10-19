public class Contador {
    private int valor=0;

    public Contador(){
        this.valor =valor;
    }

    public synchronized  void contar(){
        valor++;
    }

    public int getValor() {
        return valor;
    }



}
