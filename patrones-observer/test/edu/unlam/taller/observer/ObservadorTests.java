package edu.unlam.taller.observer;

import org.junit.Test;
import static org.junit.Assert.*;

public class ObservadorTests {

	@Test
	public void queUnObservadorEsNotificado() {
		
		BotonRojo boton = new BotonRojo();
		ObservadorStub observador = new ObservadorStub();
		
		boton.registrar(observador);
		
		assertFalse(observador.isNotificado());
		boton.presionar();
		assertTrue(observador.isNotificado());
	}
}
