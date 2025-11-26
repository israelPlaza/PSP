class CampoDeBatalla {
    private Bot primerBot;

    public synchronized void enfrentamiento(Bot bot) {
        try {
            if (primerBot == null) {
                primerBot = bot;
                System.out.println("Bot " + bot.getIdBot() + " está esperando un oponente...");
                wait(); // Espera hasta que llegue el segundo bot
            } else {
                System.out.println("Enfrentamiento entre Bot " + primerBot.getIdBot() +
                        " (Energía: " + primerBot.getEnergia() + ") y Bot " + bot.getIdBot() +
                        " (Energía: " + bot.getEnergia() + ")");
                resolverEnfrentamiento(primerBot, bot);
                primerBot = null; // Campo listo para el próximo enfrentamiento
                notify(); // Despierta al siguiente bot
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private synchronized void resolverEnfrentamiento(Bot bot1, Bot bot2) {
        if (bot1.getEquipo() != bot2.getEquipo()) {
            if (bot1.getEnergia() > bot2.getEnergia()) {
                bot1.setEnergia(bot1.getEnergia() - bot2.getEnergia());
                bot2.setEnergia(0);
                System.out.println("Bot " + bot1.getIdBot() + " gana. Nueva energía: " + bot1.getEnergia());
            } else if (bot1.getEnergia() < bot2.getEnergia()) {
                bot2.setEnergia(bot2.getEnergia() - bot1.getEnergia());
                bot1.setEnergia(0);
                System.out.println("Bot " + bot2.getIdBot() + " gana. Nueva energía: " + bot2.getEnergia());
            } else  {
                bot1.setEnergia(0);
                bot2.setEnergia(0);
                System.out.println("Ambos bots empatan y quedan eliminados.");
            }
        } else {
            bot1.setEnergia(bot1.getEnergia() + bot2.getEnergia());
            bot2.setEnergia(0);
            System.out.println("Bot " + bot1.getIdBot() + " absorbe la energía del bot " + bot2.getIdBot() +
                    ". Nueva energía: " + bot1.getEnergia());
        }
    }
}