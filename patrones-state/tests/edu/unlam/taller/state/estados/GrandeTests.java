package edu.unlam.taller.state.estados;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GrandeTests {

	private Estado estado;
	
	@Before
	public void setUp() {
		estado = new Grande();
	}
	
	@Test
	public void cuandoRecibeDaño() {
		assertEquals(new Chiquito(), estado.recibirDaño());
	}
	
	@Test
	public void cuandoComeHongo() {
		assertEquals(estado, estado.comerHongo());
	}
	
	@Test
	public void cuandoTocaFlor() {
		assertEquals(new Piromaniaco(), estado.tocarFlor());
	}

}
