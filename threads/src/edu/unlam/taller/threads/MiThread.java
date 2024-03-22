package edu.unlam.taller.threads;

public class MiThread extends Thread {
	public MiThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + " " + getName());
			
			try {
				sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(getName() + " Listo!!!");
	}

	public static void main(String arg[]) {
		MiThread mt = new MiThread("Alfa");
		mt.start();

		new MiThread("Beta").start();
		
		Thread x = new Thread("Gamma") {
			@Override
			public void run() {
				System.out.println(getName() + " hasta aquí llegó...");
			}
		};
		x.start();
		
		System.out.println("chau");
	}
}
