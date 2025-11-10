public class GestorSala {

    // ... (variables sin cambios) ...
    private int aforo = 0;
    private int capacidMax = 50;
    private int esperaJubilado = 0;
    private int esperaPersona = 0;

    public GestorSala(int capacidMax) {
        this.capacidMax = capacidMax;
    }

    public synchronized void entrarSala(int numero) throws InterruptedException {
        esperaPersona++;
        System.out.println("Persona " + numero + " espera para entrar.");

        // ESPERAR SI: La sala está llena O hay jubilados esperando (tienen prioridad)
        while (aforo >= capacidMax || esperaJubilado > 0) {
            wait();
        }
        
        esperaPersona--;
        aforo++;
        System.out.println("Persona " + numero + " ha entrado. Aforo: " + aforo + "/" + capacidMax + ". Esperando P:" + esperaPersona + " J:" + esperaJubilado);
    }

    public synchronized void entrarSalaJubilado(int numero) throws InterruptedException {
        esperaJubilado++;
        System.out.println("Jubilado " + numero + " espera para entrar.");

        // ESPERAR SI: La sala está llena
        while (aforo >= capacidMax) {
            wait();
        }
        
        esperaJubilado--;
        aforo++;
        System.out.println("Jubilado " + numero + " ha entrado. Aforo: " + aforo + "/" + capacidMax + ". Esperando P:" + esperaPersona + " J:" + esperaJubilado);
    }

    public synchronized void salirSala(int numero) {
        aforo--;
        System.out.println("Persona " + numero + " ha salido de la sala. Aforo: " + aforo + "/" + capacidMax);
        
        // Notificar a TODOS los hilos en espera (wait())
        // para que puedan re-evaluar las condiciones de entrada.
        notifyAll();
    }

    public synchronized void notificarTEmperatura(int temperatura) {
        // (He quitado la variable TUMBRAL para usar el valor directamente)
        if (temperatura > 30) {
            if (capacidMax == 50) { // Solo notificar si hay un cambio real
                System.out.println("TEMPERATURA ALTA: Aforo baja a 35");
                capacidMax = 35;
            }
        } else {
            if (capacidMax == 35) { // Solo notificar si hay un cambio real
                System.out.println("TEMPERATURA OK: Aforo vuelve a 50");
                capacidMax = 50;
                // Notificar a los hilos en espera, ya que la capacidad ha aumentado
                // y quizás ahora puedan entrar.
                notifyAll();
            }
        }
    }
}