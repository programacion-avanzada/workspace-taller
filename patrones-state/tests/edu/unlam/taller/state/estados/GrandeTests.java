package edu.unlam.taller.state.estados;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.taller.state.estados.Chiquito;
import edu.unlam.taller.state.estados.Estado;
import edu.unlam.taller.state.estados.Grande;
import edu.unlam.taller.state.estados.Piromaniaco;

public class GrandeTests {

	Estado estado;
	
	@Before
	public void setup() {
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
