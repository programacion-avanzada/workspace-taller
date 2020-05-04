package edu.unlam.taller.codegolf;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumaPrefijosTest {

	SumaPrefijos sumaPrefijos;

	@Before
	public void Before() {
		sumaPrefijos = new SumaPrefijos();
	}
	
	private void testTodasIteraciones(int[] input, int[] expected) {
		int[] actual;
		actual = sumaPrefijos.iteracion1(input.clone());
		Assert.assertArrayEquals(expected, actual);
		actual = sumaPrefijos.iteracion2(input.clone());
		Assert.assertArrayEquals(expected, actual);
		actual = sumaPrefijos.iteracion3(input.clone());
		Assert.assertArrayEquals(expected, actual);
		actual = sumaPrefijos.iteracion4(input.clone());
		Assert.assertArrayEquals(expected, actual);
		actual = sumaPrefijos.iteracion5(input.clone());
		Assert.assertArrayEquals(expected, actual);
	}

	@Test
	public void testSimple() {
		int[] input = { 1, 2, 3 };
		int[] expected = { 1, 3, 6 };
		
		testTodasIteraciones(input, expected);
	}

	@Test
	public void testConNegativo() {
		int[] input = { 1, 2, 3, -6, -6 };
		int[] expected = { 1, 3, 6, 0, -6 };

		testTodasIteraciones(input, expected);
	}

	@Test
	public void testValoresNulos() {
		int[] input = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] expected = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };

		testTodasIteraciones(input, expected);
	}

	@Test
	public void testValoresBinarios() {
		int[] input = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096 };
		int[] expected = { 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191 };

		testTodasIteraciones(input, expected);
	}
}
