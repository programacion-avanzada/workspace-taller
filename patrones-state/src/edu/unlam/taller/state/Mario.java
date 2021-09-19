package edu.unlam.taller.state;

import edu.unlam.taller.elementos.Bloque;

public class Mario {

	private int monedas = 0;
	private EstadoMario estado = new MarioChiquito();

	public void golpearBloque(Bloque bloque) {
		estado.golpearBloque(bloque);
	}
	
	public void recogerMoneda() {
		estado.recogerMoneda(this);
	}
	
	public void comerHongo() {
		estado = estado.comerHongo();
	}

	public void hit() {
		estado = estado.hit();
	}

	public void tocarFlor() {
		estado = estado.tocarFlor();
	}

	void addMoneda() {
		this.monedas++;
	}
	
	@Override
	public String toString() {
		return estado.getClass().getSimpleName();
	}

}
