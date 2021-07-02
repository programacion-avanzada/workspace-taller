### Pruebas JUnit

### Pruebas unitarias
Las pruebas unitarias son una herramienta que tenemos los desarrolladores para verificar que el código que escribimos se comporte de la manera que creemos y que necesitamos. Es un arma fundamental en el desarrollo de software, ampliamente utilizado.

### ¿Por qué utilizar pruebas unitarias?
- Porque nos permiten automatizar pruebas de código una parte fundamental en el CI/CD.
- Porque nos permiten verificar que los cambios que realizamos, no degradan funcionalidades anteriores.
- Porque nos permiten realizar mejoras al código mas rápido, tenemos tests que nos demuestran que el refactor no altero el normal funcionamiento.
- Porque ademas sirven, entre comillas, como documentación del código (aunque sea necesario realizar documentación por escrita, nos brinda otra vision del funcionamiento).
- Porque nos permiten verificar si nuestro código es mantenible, código donde utilizamos implementaciones y no abstracciones serian imposibles de testear, un test nos mostraría este escenario.
- Otra gran utilidad de los tests:
- En muchas empresas se utiliza una metodología llamada TDD (test driven development), es una metodología en la cual primero escribimos los tests y luego desarrollamos la solución/implementación. Es un punto que suma al momento de buscar trabajo en la industria.

### Buenas prácticas
Las pruebas deben ser independientes, cualquier cambio en el código fuente no debe afectar los tests.
Cada test debe probar un único escenario.
Utilizar inyección de depencias, y al utilizarla utilizar interfaces y no implementaciones.
Los resultados deben ser consistentes, nos tienen que garantizar que la salida es la esperada.


### Capturar excepciones
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

Fuentes: [https://github.com/programacion-avanzada/workspace-taller/issues/url](url)
[https://junit.org/junit4/javadoc/4.13/org/junit/Assert.html](url)
[https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html](url)
[https://www.baeldung.com/junit-assert-exception](url)
