import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CompeticionBots {
    public static void main(String[] args) {
        CampoDeBatalla campo = new CampoDeBatalla();
        List<Bot> bots = new ArrayList<>();

        // Crear y lanzar 10 bots
        for (int i = 1; i <= 10; i++) {
            int energiaInicial = ThreadLocalRandom.current().nextInt(10, 1001); // Aleatorio entre 10 y 1000
            Bot bot = new Bot(i, energiaInicial, campo);
            bots.add(bot);
            bot.start();
        }

        // Esperar a que terminen todos los bots
        for (Bot bot : bots) {
            try {
                bot.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("La competición ha terminado.");
    }
}