CODEGOLF

¿Qué es CodeGolf?
CodeGolf es un tipo de competencia de programación en la que los participantes se esfuerzan por lograr el código fuente más corto posible que implemente un determinado algoritmo. Los desafíos y torneos de golf de código también se pueden nombrar con el lenguaje de programación utilizado (Java, C++, C#, Ruby, Phyton).

¿De dónde salió el termino CodeGolf?
El término "CodeGolf " se deriva de la similitud de su objetivo con el del golf convencional, donde los participantes buscan lograr la puntuación más baja posible, en lugar de la más alta, como es el estándar en la mayoría de los deportes y sistemas de puntuación de juegos. Mientras que los jugadores de golf convencionales intentan minimizar el número de golpes necesarios para completar el juego, los participantes de CodeGolf ponen su inteligencia y audacia al servicio de reducir el número de golpes de tecla necesarios para escribir el programa.

Ejemplo de ejercicio de codegolf :
Ejercicio fizzbuzz, se trata de imprimir los números del 1 al 100, pero en lugar de los números múltiplos de 3 se debe imprimir "Fizz" y en lugar de los múltiplos de 5 se debe imprimir "Buzz". Por último en lugar de los números múltiplos de 3 y de 5, se debe imprimir "FizzBuzz"

-Un ejemplo de resolución sin codegolf sería

for (int i = 1; i <= 100; i++) {
	if (i % 3 == 0 && i % 5 == 0)
		System.out.println("fizzbuzz ");
	else if (i % 3 == 0)
		System.out.print("fizz ");
	else if (i % 5 == 0)
		System.out.print("buzz ");
	else
		System.out.print(i + " ");
}

-Un ejemplo de resolución del mismo ejercicio pero con codegolf sería

for (int i = 1; i < 101; i++) {
		String c = (i % 3 == 0?"Fizz":"")+(i % 5 == 0?"Buzz":"");
		System.out.println((c != "")?c:i);
	}
	

Algunos ejercicios para empezar a pensar
1) Números primos
Imprima todos los números primos del 1 al 100 inclusive, cada uno en su propia línea.

2) Divisores
Un número es divisor de otro número si se puede dividir sin resto.
Imprime los divisores positivos de cada número del 1 al 100 inclusive, en su propia línea, con cada divisor separado por un espacio.

3) Números malignos
Un número maligno es un número no negativo que tiene un número par de 1 en su expansión binaria.
Imprime todos los números malignos del 0 al 50 inclusive, cada uno en su propia línea.

4) Números felices.

Un número feliz se define por la siguiente secuencia: comenzando con cualquier número entero positivo, reemplace el número por la suma de los cuadrados de sus dígitos en base diez y repita el proceso hasta que el número sea igual a 1 (donde permanecerá), o se repite interminablemente en un ciclo que no incluye 1. Aquellos números para los que este proceso termina en 1 son números felices, mientras que los que no terminan en 1 son números tristes.
Por ejemplo, 19 es feliz, ya que la secuencia asociada es:

1^ + 9^ = 82
8^ + 2^ = 68
6^ + 8^ = 100
1^ + 0^ + 0^ = 1.

Imprime todos los números felices del 1 al 200 inclusive, cada uno en su propia línea.


FUENTES DE INFORMACIÓN
https://en.wikipedia.org/wiki/Code_golf
https://meta.stackexchange.com/questions/20736/what-is-code-golf-on-stack-overflow

FUENTE DE EJERCICIOS PROPUESTOS
https://code.golf/