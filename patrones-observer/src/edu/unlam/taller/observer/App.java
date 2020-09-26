package edu.unlam.taller.observer;

public class App {

	public static void main(String[] args) {
		BotonRojo boton = new BotonRojo();
		
		boton.registrar(new Personaje("Blue"));
		boton.registrar(new Personaje("Red"));
		
		boton.presionar();
	}
}
