package edu.unlam.taller.state;

import edu.unlam.taller.elementos.Bloque;

public class MarioChiquito extends EstadoMario {

	@Override
	public EstadoMario comerHongo() {
		return new SuperMario();
	}

	@Override
	public EstadoMario hit() {
		return new MarioMuerto();
	}

	public EstadoMario tocarFlor() {
		return new MarioFuego();
	}

	@Override
	public void golpearBloque(Bloque bloque) { }
	
}
