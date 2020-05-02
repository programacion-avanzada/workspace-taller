package edu.unlam.taller.state.estados;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.taller.state.estados.Chiquito;
import edu.unlam.taller.state.estados.Estado;
import edu.unlam.taller.state.estados.Grande;
import edu.unlam.taller.state.estados.Muerto;
import edu.unlam.taller.state.estados.Piromaniaco;

public class ChiquitoTests {

	Estado estado;
	
	@Before
	public void setup() {
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
