public class SensorTemperatura extends Thread {
    private GestorSala gestorSala; // Referencia al gestor
    private int temperatura = 25;  // Temperatura inicial razonable
    private boolean fin = false;

    // CONSTRUCTOR: Recibe el gestor para poder avisarle después
    public SensorTemperatura(GestorSala gestorSala) {
        this.gestorSala = gestorSala;
    }

    @Override
    public void run() {
        while (!fin) {
            // Simular temperatura: número aleatorio entre 15 y 45 grados
            // Tu lógica anterior (Math.random()*5-5) daba casi siempre 0 o -1 al pasarlo a int
            temperatura = (int) (Math.random() * 30) + 15; 
            
            gestorSala.notificarTemperatura(temperatura);
            
            try {
                Thread.sleep(3000); // Mide cada 3 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminar() {
        this.fin = true;
    }
}