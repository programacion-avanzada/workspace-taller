package edu.unlam.taller.state;

import org.junit.Assert;
import org.junit.Test;

import edu.unlam.taller.elementos.Bloque;

public class AccionesTests {

	@Test
	public void marioChiquitoGolpeaBloque() {
		
		Mario mario = new Mario();
		Bloque bloque = new Bloque();
		
		mario.golpearBloque(bloque);
		
		Assert.assertTrue(bloque.estaSano());
		
	}
	
	@Test
	public void marioGrandeGolpeaBloque() {
		
		Mario mario = new Mario();
		mario.comerHongo();
		Bloque bloque = new Bloque();
		
		mario.golpearBloque(bloque);
		
		Assert.assertFalse(bloque.estaSano());
	}
}
