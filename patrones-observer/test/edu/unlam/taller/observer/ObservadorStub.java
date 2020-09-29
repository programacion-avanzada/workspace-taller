package edu.unlam.taller.observer;

public class ObservadorStub extends Observador {

	private boolean notificado = false;

	@Override
	public void notificarse() {
		notificado  = true;
	}
	
	public boolean isNotificado() {
		return this.notificado;
	}

}
