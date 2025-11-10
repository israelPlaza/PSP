public class GestorPiezas {
    private int piezasAlmacenadas;

    /**
     * Constructor: inicializa el almacén a 0 piezas.
     */
    public GestorPiezas() {
        this.piezasAlmacenadas = 0;
    }

    /**
     * Método invocado por los hilos Productores.
     * Añade una cantidad de piezas al almacén y despierta a todos
     * los consumidores que puedan estar esperando.
     */
    public synchronized void agregarPiezas(int cantidadPiezas) {
        // Precondición: solo procesar cantidades positivas
        if (cantidadPiezas <= 0) {
            // Opcional: lanzar new IllegalArgumentException("La cantidad debe ser positiva");
            return;
        }

        // 1. Añadir las piezas (almacén ilimitado)
        this.piezasAlmacenadas += cantidadPiezas;
        System.out.println(Thread.currentThread().getName() + " agregó " + cantidadPiezas +
                           ". Stock total: " + this.piezasAlmacenadas);

        // 2. Notificar a TODOS los hilos consumidores que están esperando.
        // Usamos notifyAll() para que todos despierten y re-evalúen si
        // AHORA hay suficientes piezas para su pedido particular.
        this.notifyAll();
    }

    /**
     * Método invocado por los hilos Consumidores.
     * Solicita una cantidad de piezas. Si no hay suficientes, el hilo
     * se bloquea hasta que haya suficientes O hasta que sea interrumpido
     * (por ejemplo, por su propio hilo temporizador).
     */
    public synchronized void solicitarPiezas(int cantidadPiezas) throws InterruptedException {
        // Precondición: solo procesar cantidades positivas
        if (cantidadPiezas <= 0) {
            // Opcional: lanzar new IllegalArgumentException("La cantidad debe ser positiva");
            return;
        }

        System.out.println(Thread.currentThread().getName() + " solicita " + cantidadPiezas +
                           " (Stock actual: " + this.piezasAlmacenadas + ")");

        // 1. Condición de espera:
        // Se usa 'while' en lugar de 'if' por dos razones (crucial en monitores):
        //    a) Para re-evaluar la condición si el hilo despierta pero otro
        //       consumidor fue más rápido y ya cogió las piezas (condiciones de carrera).
        //    b) Para manejar "despertares espurios" (spurious wakeups).
        while (this.piezasAlmacenadas < cantidadPiezas) {
            // 2. Bloqueo (espera):
            // El hilo libera el 'lock' del monitor y se pone a dormir.
            // Si es despertado por notifyAll() o interrumpido (timeout),
            // volverá al paso 1 (re-evaluar el 'while').
            System.out.println(Thread.currentThread().getName() + " esperando...");
            this.wait();
        }

        // 3. Condición cumplida (sale del while):
        // Si el hilo llega aquí, significa que:
        //    a) NO fue interrumpido (no se lanzó InterruptedException).
        //    b) Hay suficientes piezas (piezasAlmacenadas >= cantidadPiezas).

        // 4. Retirar las piezas
        this.piezasAlmacenadas -= cantidadPiezas;
        System.out.println(Thread.currentThread().getName() + " retiró " + cantidadPiezas +
                           ". Stock restante: " + this.piezasAlmacenadas);
    }
}
