package edu.unlam.taller.observer;

import java.util.LinkedList;
import java.util.List;

public class Observable {

	private List<Observador> observadores = 
			new LinkedList<Observador>();

	public void registrar(Observador o) {
		this.observadores.add(o);
	}

	protected void notificar() {
		for (Observador observador : observadores) {
			observador.notificarse();
		}
	}

}
