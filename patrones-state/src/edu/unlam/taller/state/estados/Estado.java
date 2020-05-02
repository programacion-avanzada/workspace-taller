package edu.unlam.taller.state.estados;

public abstract class Estado {

	public Estado comerHongo() {
		return this;
	}

	public Estado recibirDaño() {
		return this;
	}

	public Estado tocarFlor() {
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		return obj.getClass().getName().equals(this.getClass().getName());
	}
	
}
