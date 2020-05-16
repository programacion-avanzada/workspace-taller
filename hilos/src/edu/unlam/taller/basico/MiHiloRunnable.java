package edu.unlam.taller.basico;

public class MiHiloRunnable implements Runnable{

	private String name;
	
	public MiHiloRunnable(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				Thread.sleep(100);
				System.out.println(i + " " + getName());
			}
			System.out.println(getName() + " Listo!!!");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		new Thread(new MiHiloRunnable("Lucas")).start();
		new Thread(new MiHiloRunnable("Fede")).start();
		
	}	
	
}
