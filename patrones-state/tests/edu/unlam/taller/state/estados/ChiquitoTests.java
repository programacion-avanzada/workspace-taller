package edu.unlam.taller.state.estados;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ChiquitoTests {

	private Estado estado;
	
	@Before
	public void setUp() {
		estado = new Chiquito();
	}
	
	@Test
	public void cuandoRecibeDaño() {
		assertEquals(new Muerto(), estado.recibirDaño());
	}
	
	@Test
	public void cuandoComeHongo() {
		assertEquals(new Grande(), estado.comerHongo());
	}
	
	@Test
	public void cuandoTocaFlor() {
		assertEquals(new Piromaniaco(), estado.tocarFlor());
	}

}
