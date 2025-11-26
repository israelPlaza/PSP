public class CampoBatalla {
private int luchador;
    private int equipoLuchador1;
    private int equipoLuchador2;
    private int energiaLuchador1;
    private int energiaLuchador2;
    int resultado;


   public CampoBatalla()
    {
        this.luchador = 0;
    }


    public synchronized void entrarCampo() throws InterruptedException
    {
        // Mientras que en contador haya 2.
        while (luchador == 2) 
        {
            wait(); // Esperar a que haya espacio para entrar.
        }
        luchador++;
    }


    public synchronized int enfrentamientoBots(int energia, int equipo, int id) throws InterruptedException{
        
       if(luchador == 1){
            //  Primer luchador entra
            energiaLuchador1 = energia;
            equipoLuchador1 = equipo;
            System.out.println("Luchador 1 Listo: Jugador: " + id);
            while (luchador < 2) 
            {
                wait(); // Espera al siguiente luchador
            }
       }
       else if (luchador == 2){
            // Segundo luchador entra.
            energiaLuchador2 = energia;
            equipoLuchador2 = equipo;
            System.out.println("Luchador 2 Listo: Jugador " + id);
            notifyAll();  // Notificamos al primer luchador.
       }
    if(equipoLuchador1 == energiaLuchador2)   // Mismo equipo. Empate.
       { 
            System.out.println("Ambos luchadores son del mismo equipo.");  
            resultado =  energiaLuchador2 + energiaLuchador1;
            System.out.println("Jugador 2 muere.");
       } 
            else if (energiaLuchador1 > energiaLuchador2) 
            {
                resultado = energiaLuchador1 - energiaLuchador2;
                System.out.println("Jugador 1 gana con " + resultado + " de energia.");
            } 
                else
                {
                    resultado = energiaLuchador2 - energiaLuchador1;
                    System.out.println("Jugador 2 gana con " + resultado + " de energia.");
                }
        /*
         * ---------------
         * RESETEAR CAMPOS
         * ---------------
         */
        luchador--;     // Decrementamos el luchador una vez que ha completado los if.
        if(luchador == 0)   // Si el luchador es igual a 0 notifica a otros luchadores.
        {
            notifyAll();    // Permitir que otros bots entren.
        }
        return resultado;// Devolvemos el resultado.
    }

    

}
