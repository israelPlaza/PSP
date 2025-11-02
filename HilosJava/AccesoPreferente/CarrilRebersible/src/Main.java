public class Main {
    public static void main(String[] args) throws Exception {
        Puente puente = new Puente(2);
		Vehiculo vehiculo;
		Sentido sentido;
		Tipo tipo;
		for (int i=0;i<15;i++)
		{
			sentido = (Math.random()>=0.5)?Sentido.A:Sentido.B;
			tipo = (Math.random()>=0.9)?Tipo.AMBULANCIA:Tipo.COCHE;
			vehiculo = new Vehiculo(i, puente, sentido, tipo);
			vehiculo.start();
		}
    }
}
