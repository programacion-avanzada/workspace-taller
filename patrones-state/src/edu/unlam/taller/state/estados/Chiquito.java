package edu.unlam.taller.state.estados;

public class Chiquito extends Estado {

	@Override
	public Estado comerHongo() {
		return new Grande();
	}

	@Override
	public Estado recibirDaño() {
		return new Muerto();
	}

	public Estado tocarFlor() {
		return new Piromaniaco();
	}
	
}
