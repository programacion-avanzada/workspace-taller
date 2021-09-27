### Pruebas JUnit

### Pruebas unitarias
Las pruebas unitarias son una herramienta que tenemos los desarrolladores para verificar que el código que escribimos se comporte de la manera que creemos y que necesitamos. Es un arma fundamental en el desarrollo de software, ampliamente utilizado.

### Por qué utilizar pruebas unitarias
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

```java
// En JUnit 4
@Test(expected = ArithmeticException.class)
public void esperoArithmeticException() {
	int n = 5/0;
}
```
```java
// En JUnit 5
@Test
void casoAssertArithmeticException() {
	Assert.assertThrows(ArithmeticException.class, () -> {
		int n = 5/0;
	});
}
```

Otro ejemplo, es el que se quiere obtener la cadena String de una variable del tipo Integer sin inicializar, arrojará la excepción **NullPointerException**:

```java
// En JUnit 4
@Test(expected = NullPointerException.class)
public void esperoNullPointerException() {
	Integer numero = null;
	numero.toString();
}
```
```java
// En JUnit 5
@Test
void casoAssertThrowsNullPointerException() {
	Integer numero = null;
	Assert.assertThrows(NullPointerException.class, () -> {
		numero.toString();
	});
}
```

### Ejemplos de Asserts
A continuación se dejarán ejemplos de tipos de Asserts para utilizar en JUnit, con la clase Punto

- assertTrue() y assertFalse() validan si un resultado es verdadero o falso.
- assertNotEquals() validan que 2 objetos sean distintos
	
```java
@Test
public void comparar() {
	Punto punto = new Punto(0, 0);
	Punto punto2 = new Punto(0, 0);
	Punto punto3 = new Punto(1, 0);
	Assert.assertTrue(punto.equals(punto2));
	Assert.assertFalse(punto.equals(punto3));
	Assert.assertNotEquals(punto3, punto);
}
```
	
- assertSame() y assertNotSame() prueban si dos objetos apuntan al mismo objeto

```java
@Test
public void compararClase() {
	Punto punto = new Punto(0, 0);
	Punto punto2 = new Punto(0, 0);
	Punto punto3 = punto;
	Assert.assertSame(punto, punto3);
	Assert.assertNotSame(punto, punto2);
}
```
	
- assertNull() valida si un resultado es nulo.

```java
@Test
public void nulo() {
	Punto punto4 = null;
	Assert.assertNull(punto4);
}
```
	
- assertArrayEquals() valida que 2 arrays sean iguales

```java
@Test
public void compararArray() {
	Punto[] arrayEsperado = {new Punto(1, 0),new Punto(2, 0),new Punto(3, 0)};
	Punto[] arrayResult = {new Punto(1, 0),new Punto(2, 0),new Punto(3, 0)};
	
	Assert.assertArrayEquals(arrayEsperado, arrayResult);
}
```

### Patrón 4A
El patrón sugiere dividir las pruebas unitarias en 4 etapas
- 1. Arrange:(Inicializar) Inicializar los objectos que se van a utilizar en la prueba unitaria
- 2. Act:(Actuar) Realizar las acciones deseadas en la prueba unitaria con las variables antes declaradas para tal fin
- 3. Assert: (Comprobar) Comprueba que el resultado de la prueba realizada sea el correcto
- 4. Annihilate: (Aniquilar) Eliminar todo los cambios hechos por la prueba unitaria
	
```java
@Test
public void archivos() {
	// 1. Arrange. Ponemos los objetos que necesitaremos
	String path = "test.txt";
	String texto = "Texto de prueba";
	FileWriter file = null;
	PrintWriter printerWriter = null;
	String txtRes = null;
	File fileRead = null;
	Scanner scanner;
	
	// 2. Act. Efectuamos la accion deseada
	try {
		file = new FileWriter(path);
		printerWriter = new PrintWriter(file);
		printerWriter.println(texto);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		if (file != null) {
			try {
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 3. Assert. Comprobamos si el resultado es el esperado
	fileRead = new File(path);
	try {
		scanner = new Scanner(fileRead);
		scanner.useLocale(Locale.ENGLISH);
		txtRes = scanner.nextLine();
		System.out.println(txtRes);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	Assert.assertEquals(texto, txtRes);
	
	
	
	// 4. Annihilate. Deshacemos todo lo hecho por el test.
	fileRead.delete();
}
```

Fuentes:
[https://github.com/programacion-avanzada/workspace-taller/issues/url](url)
[https://junit.org/junit4/javadoc/4.13/org/junit/Assert.html](url)
[https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html](url)
[https://www.baeldung.com/junit-assert-exception](url)
