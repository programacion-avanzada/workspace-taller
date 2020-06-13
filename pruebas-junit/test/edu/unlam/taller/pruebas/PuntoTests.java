package edu.unlam.taller.pruebas;

// se debe agregar la biblioteca de JUnit
// se deben importar las clases necesarias
import org.junit.Test;
import org.junit.Assert;
// cuidado con la clase Assert, que si nos descuidamos nos importará
// import junit.framework.Assert;
import org.junit.Before;

public class PuntoTests {

	private Punto punto;

	/*
	 * El método anotado como @Before nos permitirá ejecutar código antes de la
	 * ejecución de cada prueba
	 */
	@Before
	public void setUp() {
		punto = new Punto(0, 0);
	}

	/*
	 * Un método anotado como @Test se considera una prueba, y su resultado se
	 * catalogará como verde o rojo.
	 */
	@Test
	public void quePuedoCrearlo() {
		Assert.assertNotNull(punto);
	}

	@Test
	public void queDevuelveSusCoordenadas() {
		// El assertEquals para doubles tiene un tercer parámetro
		// que representa la tolerancia en la igualdad.
		Assert.assertEquals(0.0, punto.getX(), 0.0);
		Assert.assertEquals(0.0, punto.getY(), 0.0);
	}

	@Test
	public void queCalculaElModulo() {
		// Una buena prueba tiene cuatro pasos. En este caso no son
		// necesarios, pero lo exageraremos para ilustrarlos.

		// 1. Arrange. Ponemos los objetos que necesitaremos
		punto = new Punto(1, 1);
		double raizDeDos = Math.sqrt(2);

		// 2. Act. Efectuamos la acción deseada
		double resultado = punto.getModulo();

		// 3. Assert. Comprobamos si el resultado es el esperado
		Assert.assertEquals(raizDeDos, resultado, 0.0);

		// 4. Annihilate. Deshacemos todo lo hecho por el test.
		// Aquí no es necesario, pero si hubiéramos escrito archivos
		// o guardado registros en una base de datos, deberíamos
		// realizar la acción contraria para dejar el sistema igual
		// que antes de ejecutar la prueba.
		// Ridículamente haremos esto, en este caso (no es necesario):
		punto = null;
	}

	/*
	 * JUnit tiene muchos tipos de aserciones. Podés explorarlas aquí:
	 * https://junit.org/junit4/javadoc/4.12/org/junit/Assert.html
	 */
}
