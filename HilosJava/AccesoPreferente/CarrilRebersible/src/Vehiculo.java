public class Vehiculo extends Thread {
    private Puente puente;
    private int numero;
    private Tipo tipo;
    private Sentido sentido;

    public Vehiculo(int numero, Puente puente, Sentido sentido, Tipo tipo) {
        this.numero = numero;
        this.puente = puente;
        this.sentido = sentido;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            switch (sentido) {
                case A:
                    if (tipo == Tipo.COCHE)
                        puente.entrarA(numero, tipo);
                    else
                        puente.entrarAmbulanciasA(numero, tipo);
                    break;
                case B:
                    if (tipo == Tipo.COCHE)
                        puente.entrarB(numero, tipo);
                    else
                        puente.entrarAmbulanciasB(numero, tipo);
                    break;
            }

            Thread.sleep(2000);
            puente.salir(numero, tipo);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
