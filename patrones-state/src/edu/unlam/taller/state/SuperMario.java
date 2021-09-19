package edu.unlam.taller.state;

public class SuperMario extends EstadoMario {

	@Override
	public EstadoMario hit() {
		return new MarioChiquito();
	}
	
	@Override
	public EstadoMario tocarFlor() {
		return new MarioFuego();
	}

	@Override
	public void recogerMoneda(Mario mario) {
		// Para este ejemplo, asumimos que un SuperMario
		// cuenta las monedas recogidas x2
		mario.addMoneda();
		mario.addMoneda();
	}
}
