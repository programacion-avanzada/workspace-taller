package edu.unlam.taller.state.estados;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PiromaniacoTests {

	private Estado estado;
	
	@Before
	public void setUp() {
		estado = new Piromaniaco();
	}
	
	@Test
	public void cuandoRecibeDaño() {
		assertEquals(new Grande(), estado.recibirDaño());
	}
	
	@Test
	public void cuandoComeHongo() {
		assertEquals(estado, estado.comerHongo());
	}
	
	@Test
	public void cuandoTocaFlor() {
		assertEquals(estado, estado.tocarFlor());
	}

}
