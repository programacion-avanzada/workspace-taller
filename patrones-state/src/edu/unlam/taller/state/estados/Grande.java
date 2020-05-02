package edu.unlam.taller.state.estados;

public class Grande extends Estado {

	@Override
	public Estado recibirDaño() {
		return new Chiquito();
	}
	
	@Override
	public Estado tocarFlor() {
		return new Piromaniaco();
	}

}
