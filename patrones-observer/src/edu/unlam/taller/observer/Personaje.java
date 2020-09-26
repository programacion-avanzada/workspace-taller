package edu.unlam.taller.observer;

public class Personaje extends Observador {

	private String nombre;
		
	public Personaje(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void notificarse() {
		System.out.println(this.nombre + " > vamo a la reunion!");
	}
}
