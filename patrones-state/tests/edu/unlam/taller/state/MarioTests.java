package edu.unlam.taller.state;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MarioTests {

	private edu.unlam.taller.noState.Mario mario;
	
	@Before
	public void setUp() {
		mario = new edu.unlam.taller.noState.Mario();
	}
	
	@Test
	public void queComienzaChiquito() {
		assertEquals("MarioChiquito", mario.toString());
	}
	
	@Test
	public void comerHongo() {
		mario.comerHongo();
		assertEquals("SuperMario", mario.toString());
	}
	
	@Test
	public void tocarFlor() {
		mario.tocarFlor();
		assertEquals("MarioFuego", mario.toString());
	}
	
	@Test
	public void hit() {
		mario.hit();
		assertEquals("Muerto", mario.toString());
	}
	
	@Test
	public void queMarioGrandeNoMuereAlSerGolpeado() {
		mario.comerHongo();
		
		mario.hit();
		assertEquals("MarioChiquito", mario.toString());
	}

}
