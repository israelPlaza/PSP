

public class Vehiculo extends Thread 
{
	private int numero;
	private Sentido sentido;
	private Puente puente;
	
	public Vehiculo(int n,Sentido sentido,Puente puente)
	{
		this.numero = n;
		this.sentido = sentido;
		this.puente = puente;
	}
	
	public void run()
	{
		try 
		{
		switch (this.sentido)
		{
		case A: 
			puente.entrarA(this.numero);
			break;
		case B:
			puente.entrarB(this.numero);
			break;
		}
		
		Thread.sleep((long)(500+Math.random()*3000));
		puente.salir(this.numero);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
