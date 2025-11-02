
enum Sentido {LIBRE,A,B}
enum Tipo{COCHE,AMBULANCIA}
public class Puente 
{
	private int capacidad;
	private int ocupacion;
	private Sentido sentido;
	private Tipo tipo;
	private int nEsperandoEnA;
	private int nEsperandoEnB;
	private int esperandoAmbA;
	private int esperandoAmbB;
	

	public Puente (int n)
	{
		this.capacidad = n;
		this.ocupacion = 0;
		this.sentido = Sentido.LIBRE;
		this.tipo=tipo;
		this.nEsperandoEnA = 0;
		this.nEsperandoEnB = 0;
		this.esperandoAmbA=0;
		this.esperandoAmbB=0;
	}
	
	public synchronized void entrarA (int n) throws InterruptedException
	{
		nEsperandoEnA++;
		if (this.tipo==Tipo.AMBULANCIA) {
			esperandoAmbA++;
		}
		System.out.println(tipo+" "+n+" quiere entrar por A -> ("+nEsperandoEnA+" esperando).");
		while (this.ocupacion == this.capacidad
				|| this.sentido == Sentido.B
				|| nEsperandoEnA < nEsperandoEnB ||esperandoAmbA>0)
			wait();
		nEsperandoEnA--;
		this.ocupacion++;
		this.sentido = Sentido.A;
		System.out.println(tipo+" "+n+" entra por A -> ("+nEsperandoEnA+" esperando).");
	}

	public synchronized void entrarB (int n) throws InterruptedException
	{
		nEsperandoEnB++;
		if (this.) {
			
		}
		System.out.println("Vehiculo "+n+" quiere entrar por B -> ("+nEsperandoEnB+" esperando).");		
		while (this.ocupacion == this.capacidad
				|| this.sentido == Sentido.A
				|| nEsperandoEnB < nEsperandoEnA)
			wait();
		nEsperandoEnB--;
		this.ocupacion++;
		this.sentido = Sentido.B;
		System.out.println("Vehiculo "+n+" entra por B -> ("+nEsperandoEnB+" esperando).");
	}
	
	public synchronized void salir(int n)
	{
		this.ocupacion--;
		if (this.ocupacion == 0)
			this.sentido = Sentido.LIBRE;
		System.out.println("Vehiculo "+n+" abandona puente.");
		notifyAll();
	}
}
