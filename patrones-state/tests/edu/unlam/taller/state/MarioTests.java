package edu.unlam.taller.state;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.unlam.taller.state.estados.Chiquito;

public class MarioTests {

	Mario mario;
	
	@Before
	public void setup() {
		mario = new Mario();
	}
	
	@Test
	public void queComienzaChiquito() {
		assertEquals(new Chiquito(), mario.getEstado());
	}

}
