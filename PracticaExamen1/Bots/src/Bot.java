public class Bot extends Thread{
 private int equipo;  // 0 para A, 1 para B
    private int id; // El identificador de cada bot
    private int energia; // Energia del botde 10 a 1000.
    private CampoBatalla campo;

    public Bot(int id, CampoBatalla campo, int energia)
    {
        this.id = id;
        this.campo = campo;
        this.energia = energia;
        if(energia % 2 == 0)
        {
            equipo = 0;
        } 
        else 
        {
            equipo = 1;
        }
    }

    public void run() 
    {
        while (energia > 0) 
        {
            try {
                campo.entrarCampo();
                sleep(1000);    //Simular tiempo de espera.
                energia = campo.enfrentamientoBots(energia, equipo, id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }       
        }
        System.out.println("Bot " + id + " del equipo " + equipo + " ha muerto.");
    }
}
