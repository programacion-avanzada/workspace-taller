package edu.unlam.taller.elementos;

public class Bloque {

	boolean sano = true;
	
	public void golpear() {
		this.sano = false;
	}
	
	public boolean estaSano() {
		return this.sano;
	}
	
}
