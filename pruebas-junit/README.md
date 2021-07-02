### Pruebas JUnit

A continuación se dejarán algunos ejemplos para probar si se lanzó una excepción.
Dentro de **JUnit 4** se realizará a través del atributo `expected` en la anotacion `@Test` con el tipo esperado. En cambio en **JUnit 5**, se prueba con el método `assertThrows`.

Por ejemplo, se desea probar que la siguiente operación aritmética "5/0", este caso debería arrojar una excepción del tipo **ArithmeticException** :

```
// En JUnit 4
@Test(expected = ArithmeticException.class)
public void esperoArithmeticException() {
	int n = 5/0;
}
```
```
// En JUnit 5
@Test
void casoAssertArithmeticException() {
	Assert.assertThrows(ArithmeticException.class, () -> {
		int n = 5/0;
	});
}
```

Otro ejemplo, es el que se quiere obtener la cadena String de una variable del tipo Integer sin inicializar, arrojará la excepción **NullPointerException**:

```
// En JUnit 4
@Test(expected = NullPointerException.class)
public void esperoNullPointerException() {
	Integer numero = null;
	numero.toString();
}
```
```
// En JUnit 5
@Test
void casoAssertThrowsNullPointerException() {
	Integer numero = null;
	Assert.assertThrows(NullPointerException.class, () -> {
		numero.toString();
	});
}
```
