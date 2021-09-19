package edu.unlam.taller.state;

public class MarioFuego extends EstadoMario {

	@Override
	public EstadoMario hit() {
		return new SuperMario();
	}
}
