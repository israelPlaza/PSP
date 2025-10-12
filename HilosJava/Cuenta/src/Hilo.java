public class Hilo extends Thread{

    Banco banco;
    private int numero;

    public Hilo(Banco banco, int numero) {
        this.banco = banco;
        this.numero = numero;
    }
    @Override
    public void run(){
        System.out.println("Soy el hilo " +numero);
        
        if (numero==0) {
            banco.retirarDinero(700);
            System.out.println("He retirado 700 y quedan: "+banco.getSaldo());
        }if (numero ==1) {
            banco.retirarDinero(500);
            System.out.println("He retirado 500 y quedan: "+banco.getSaldo());
        }if (numero ==2) {
            banco.retirarDinero(400);
            System.out.println("He retirado 400 y quedan: "+banco.getSaldo());
        }

    }

}
