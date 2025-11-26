class Bot extends Thread {
    private final int id;
    private final char equipo;
    private int energia;
    private static CampoDeBatalla campoDeBatalla;

    public Bot(int id, int energiaInicial, CampoDeBatalla campo) {
        this.id = id;
        this.equipo = (id % 2 == 0) ? 'A' : 'B';
        this.energia = energiaInicial;
        campoDeBatalla = campo;
    }

    public int getIdBot() {
        return id;
    }

    public char getEquipo() {
        return equipo;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    @Override
    public void run() {
        while (energia > 0) {
            campoDeBatalla.enfrentamiento(this);
        }
        System.out.println("Bot " + id + " del equipo " + equipo + " ha sido eliminado.");
    }
}