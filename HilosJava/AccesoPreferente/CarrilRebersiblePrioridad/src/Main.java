package Principal;

public class Main {

	public static void main(String[] args) 
	{
		Puente puente = new Puente(2);
		Vehiculo v;
		Sentido s;
		for (int i=0;i<15;i++)
		{
			s = (Math.random()>=0.5)?Sentido.A:Sentido.B;
			v = new Vehiculo(i,s,puente);
			v.start();
		}

	}

}
