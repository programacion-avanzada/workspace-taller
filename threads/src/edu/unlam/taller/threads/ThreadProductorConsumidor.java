package edu.unlam.taller.threads;

import java.util.LinkedList;

public class ThreadProductorConsumidor {
	public final static int MAX_CANTIDAD = 20;

	public static void main(String[] args) throws InterruptedException {
		final ProductorConsumidor pc = new ProductorConsumidor();

		// Se crea el thread productor
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.producir();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Se crea el thread consumidor
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consumir();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Se inician ambos threads
		t1.start();
		t2.start();

		// Se espera por el finalizado de ambos threads
		t1.join();
		t2.join();

		System.out.println("Fin");
	}

	public static class ProductorConsumidor {
		LinkedList<Integer> almacen = new LinkedList<>();
		int capacidad = 5;

		// Metodo invocado por el productor
		public synchronized void producir() throws InterruptedException {
			int id = 0;

			while (id < MAX_CANTIDAD) {
				// El thread del productor espera mientras el almacen esta lleno
				while (almacen.size() == capacidad) {
					wait();
				}

				System.out.println("🌳 -> 🍎 #" + id);
				almacen.add(id++);

				// Notifico al consumidor para que sepa que puede consumir (activa el wait)
				notify();
				// Thread.sleep(300);
			}
		}

		// Metodo invocado por el consumidor
		public synchronized void consumir() throws InterruptedException {
			boolean continuar = true;
			while (continuar) {
				// El thread del productor espera mientras el almacen esta vacio
				while (almacen.size() == 0) {
					wait();
				}

				int producto = almacen.removeFirst();
				System.out.println("😋 <- 🍎 #" + producto);

				continuar = producto < MAX_CANTIDAD - 1;

				// Notifico al productor para que sepa que hay lugar para producir
				notify();
				// Thread.sleep(300);
			}
		}
	}
}
