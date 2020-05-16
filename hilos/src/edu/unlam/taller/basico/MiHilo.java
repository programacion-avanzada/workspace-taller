package edu.unlam.taller.basico;

public class MiHilo extends Thread {

	public MiHilo(String name) {
		super(name);
	}

	public void run() {

		try {
			for (int i = 1; i <= 10; i++) {
				sleep(100);
				System.out.println(i + " " + getName());
			}
			System.out.println(getName() + " Listo!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String arg[]) {

		MiHilo mt = new MiHilo("Lucas");
		mt.start();

		new MiHilo("Julius").start();

		new Thread("Fede") {
			public void run() {
				System.out.println(getName() + " Hasta aquí llegó...");
			}
		}.start();

	}
}
