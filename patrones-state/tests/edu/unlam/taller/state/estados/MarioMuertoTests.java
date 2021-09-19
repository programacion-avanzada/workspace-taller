package edu.unlam.taller.state.estados;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.taller.state.EstadoMario;
import edu.unlam.taller.state.MarioMuerto;

public class MarioMuertoTests {

	private EstadoMario estado;
	
	@Before
	public void setUp() {
		estado = new MarioMuerto();
	}
	
	@Test
	public void cuandoRecibeDaño() {
		assertEquals(new MarioMuerto(), estado.hit());
	}
	
	@Test
	public void cuandoComeHongo() {
		assertEquals(new MarioMuerto(), estado.comerHongo());
	}
	
	@Test
	public void cuandoTocaFlor() {
		assertEquals(new MarioMuerto(), estado.tocarFlor());
	}

}
