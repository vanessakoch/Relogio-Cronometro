package so;

public class Singleton {

	private static Singleton uniqueInstance = new Singleton();
	public int hora;
	public int minuto;
	public int segundo;

	private Singleton() {
		hora = 0;
		minuto = 0;
		segundo = 0;
	}

	public static Singleton getInstance() {
		return uniqueInstance;
	}

	public void visualizaRelogio() {
		System.out.printf("\n%d:%d:%d\n", hora, minuto, segundo);
	}
}
