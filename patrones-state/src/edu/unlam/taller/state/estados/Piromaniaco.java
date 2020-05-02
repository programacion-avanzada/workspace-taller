package edu.unlam.taller.state.estados;

public class Piromaniaco extends Estado {

	@Override
	public Estado recibirDaño() {
		return new Grande();
	}

}
