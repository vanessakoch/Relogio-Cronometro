package so;

public class Cronometro implements Runnable {
	public int hora;
	public int minuto;
	public int segundo;
	public boolean pausa;

	public Cronometro() {
		super();
		this.hora = 0;
		this.minuto = 0;
		this.segundo = 0;
		this.pausa = false;
	}

	public void run() {

		while (true) {
			verificaPausa();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			segundo++;

			if (segundo >= 60) {
				minuto++;
				segundo = 0;
			}

			if (minuto >= 60) {
				hora++;
				minuto = 0;
			}

			if (hora >= 24) {
				hora = 0;
			}
		}
	}

	public void resetaCronometro() {
		hora = 0;
		minuto = 0;
		segundo = 0;
	}

	public void visualizaCronometro() {
		System.out.printf("\n%d:%d:%d\n", hora, minuto, segundo);
	}

	public void verificaPausa() {
		while (pausa) {
			Thread.interrupted();
		}
	}

	public void setPausa(boolean paraNaoPara) {
		this.pausa = paraNaoPara;
		if (pausa == false)
			new Thread();
	}
}
