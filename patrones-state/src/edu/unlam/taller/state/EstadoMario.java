package edu.unlam.taller.state;

import edu.unlam.taller.elementos.Bloque;

public abstract class EstadoMario {

	public EstadoMario comerHongo() {
		return this;
	}

	public EstadoMario hit() {
		return this;
	}

	public EstadoMario tocarFlor() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		return obj.getClass().getName().equals(this.getClass().getName());
	}

	public void golpearBloque(Bloque bloque) {
		bloque.golpear();
	}

	public void recogerMoneda(Mario mario) {
		mario.addMoneda();
	}
	
}
