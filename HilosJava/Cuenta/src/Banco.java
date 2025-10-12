public class Banco {

    private int saldo= 1000;

    public Banco() {
    
    }

    public synchronized   void  retirarDinero(int dinero){
        saldo= saldo - dinero;
    }

    public int getSaldo() {
        return saldo;
    }


}
