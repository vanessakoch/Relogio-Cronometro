package so;

public class Alarme extends Thread {
	public int hora;
	public int minuto;
	public int horaAlarme;
	public int minutoAlarme;

	Singleton singl = Singleton.getInstance();

	public Alarme(int hora, int minuto) {
		this.hora = hora;
		this.minuto = minuto;
	}

	public void run() {

		if (hora >= 0 && hora <= 24 && minuto >= 0 && minuto <= 59) {
			horaAlarme = hora;
			minutoAlarme = minuto;
			while (true) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (horaAlarme == singl.hora && minutoAlarme == singl.minuto) {
					System.out.println(
							"\nALARME ALARME ALARME ALARME\nALARME ALARME ALARME ALARME\nALARME ALARME ALARME ALARME\n");
					break;
				}
			}

		} else {
			System.out.println("\nFormato de hora inv�lido!");
		}
	}
}
