public class Main {
    public static void main(String[] args) throws Exception {
      CampoBatalla campo = new CampoBatalla();
        Bot[] bots = new Bot[10];
        int energia;

        for(int i = 0; i < bots.length; i++)
        {
            /*
             * 10 + (int)(Math.random()*(991))
             * 10 + --> Desplaza el rango generado para que comience en 10, dando como rsultado un numero entre 10 y 1000.
             * Math.random() * (991) --> Escala el numero a un rango entre 0 a 991
             * 
             */
            energia = 10 + (int)(Math.random()*(991));
            bots[i] = new Bot(i, campo, energia);
            bots[i].start();
        }

        //Esperar a que terminen todos los bots.
        for (Bot bot : bots) 
        {
            try 
            {
                bot.join();
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        System.out.println("Todos los bots han Batallado.");
    }
    
}
