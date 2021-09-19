package edu.unlam.taller.state.estados;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.taller.state.EstadoMario;
import edu.unlam.taller.state.MarioChiquito;
import edu.unlam.taller.state.MarioFuego;
import edu.unlam.taller.state.MarioMuerto;
import edu.unlam.taller.state.SuperMario;

public class MarioChiquitoTests {

	private EstadoMario estado;
	
	@Before
	public void setUp() {
		estado = new MarioChiquito();
	}
	
	@Test
	public void cuandoRecibeDaño() {
		assertEquals(new MarioMuerto(), estado.hit());
	}
	
	@Test
	public void cuandoComeHongo() {
		assertEquals(new SuperMario(), estado.comerHongo());
	}
	
	@Test
	public void cuandoTocaFlor() {
		assertEquals(new MarioFuego(), estado.tocarFlor());
	}

}
