package edu.unlam.taller.threads;

public class MiThread extends Thread {
	public MiThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " " + getName());
			/*
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
		}
		System.out.println(getName() + " Listo!!!");
	}

	public static void main(String arg[]) {
		MiThread mt = new MiThread("Lucas");
		mt.start();

		new MiThread("Julius").start();
		
		new Thread("Fede") {
			@Override
			public void run() {
				System.out.println(getName() + " Hasta aquí llegó...");
			}
		}.start();
	}
}
