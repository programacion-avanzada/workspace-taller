package edu.unlam.taller.observer;

public class BotonRojo extends Observable {
	
	public void presionar() {
		// más lógica relativa a la presión del botón
		notificar();
	}
}
