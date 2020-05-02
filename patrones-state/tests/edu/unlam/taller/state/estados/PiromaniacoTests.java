package edu.unlam.taller.state.estados;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.taller.state.estados.Estado;
import edu.unlam.taller.state.estados.Grande;
import edu.unlam.taller.state.estados.Piromaniaco;

public class PiromaniacoTests {

	Estado estado;
	
	@Before
	public void setup() {
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
