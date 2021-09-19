package edu.unlam.taller.state.estados;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.taller.state.EstadoMario;
import edu.unlam.taller.state.MarioFuego;
import edu.unlam.taller.state.SuperMario;

public class MarioFuegoTests {

	private EstadoMario estado;
	
	@Before
	public void setUp() {
		estado = new MarioFuego();
	}
	
	@Test
	public void cuandoRecibeDaño() {
		assertEquals(new SuperMario(), estado.hit());
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
