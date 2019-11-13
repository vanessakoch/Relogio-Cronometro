package so;

public class Relogio implements Runnable {

	Singleton singl = Singleton.getInstance();

	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			singl.segundo++;

			if (singl.segundo >= 60) {
				singl.minuto++;
				singl.segundo = 0;
			}

			if (singl.minuto >= 60) {
				singl.hora++;
				singl.minuto = 0;
			}

			if (singl.hora >= 24) {
				singl.hora = 0;
			}
		}
	}
}
