package so;

import java.util.Scanner;

public class Thread1 {

	public static void main(String[] args) throws InterruptedException {
		Scanner t = new Scanner(System.in);

		int opcao;

		Singleton singl = Singleton.getInstance();
		Relogio relogio = new Relogio();
		Cronometro cronometro = new Cronometro();

		Thread th1 = new Thread(relogio);
		Thread th3 = new Thread(cronometro);

		th1.start();

		do {
			menu();
			opcao = t.nextInt();

			switch (opcao) {

			case 1:
				System.out.println("\nDigite a hora, o minuto e o segundo:");
				singl.hora = t.nextInt();
				singl.minuto = t.nextInt();
				singl.segundo = t.nextInt();
				break;

			case 2:
				singl.visualizaRelogio();
				break;

			case 3:
				if (!th3.isAlive()) {
					th3.start();
				} else {
					cronometro.setPausa(false);
				}
				cronometro.visualizaCronometro();
				break;

			case 4:
				cronometro.visualizaCronometro();
				cronometro.setPausa(true);
				break;

			case 5:
				cronometro.resetaCronometro();
				cronometro.visualizaCronometro();
				break;

			case 6:
				System.out.println("\nDigite a hora e o minuto do alarme:");
				int horaAlarme = t.nextInt();
				int minutoAlarme = t.nextInt();
				Alarme alarme = new Alarme(horaAlarme, minutoAlarme);
				Thread th6 = new Thread(alarme);
				th6.start();
				break;

			case 7:
				cronometro.visualizaCronometro();
				break;

			case 0:
				System.exit(0);
				break;

			default:
				break;
			}

		} while (opcao != 0);

		t.close();
	}

	private static void menu() {
		System.out.println("\n1 - Ajustar horário");
		System.out.println("2 - Visualizar horário");
		System.out.println("3 - Iniciar cronômetro");
		System.out.println("4 - Parar cronômetro");
		System.out.println("5 - Zerar cronômetro");
		System.out.println("6 - Definir alarme");
		System.out.println("7 - Visualizar cronômetro");
		System.out.println("0 - Sair");
	}
}