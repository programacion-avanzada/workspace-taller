package edu.unlam.taller.codegolf;

public class SumaPrefijos {

	/**
	 * 
	 * Construir un array b de sumas de prefijos del array dado a
	 * 
	 * b está definido como:
	 * 
	 * | b[0] = a[0] | b[1] = a[0] + a[1] | b[2] = a[0] + a[1] + a[2] | ... | b[n -
	 * 1] = a[0] + a[1] + ... + a[n - 1]
	 * 
	 * donde n es el largo de a
	 * 
	 * Ejemplo
	 * 
	 * Para a = [1, 2, 3], la salida deberá ser sumaPrefijos(a) = [1, 3, 6].
	 * 
	 * b será igual a [1, 1 + 2, 1 + 2 + 3] = [1, 3, 6]
	 * 
	 * Input/Output
	 * 
	 * [input] array.integer a
	 * 
	 * Constantes garantizadas: 3 ≤ a.length ≤ 104, -1000 ≤ a[i] ≤ 1000.
	 * 
	 * [output] array.integer
	 */
	
	// Nota: La suma de los chars es +2 por ser calculado con el nombre base "sumaPrefijos" y no "iteracionx"

	// 154 chars
	int[] iteracion1(int[] array) {
		int suma = 0;
		int largo = array.length;
		int[] nuevo = new int[largo];

		for (int i = 0; i < largo; i++) {
			suma += array[i];
			nuevo[i] = suma;
		}

		return nuevo;
	}

	// 104 chars
	int[] iteracion2(int[] a) {
		int s = 0, l = a.length, i = 0;
		int[] n = new int[l];

		for (; i < l; i++) {
			s += a[i];
			n[i] = s;
		}

		return n;
	}

	// 73 chars
	int[] iteracion3(int[] a) {
		for (int i = 1; i < a.length;)
			a[i] += a[i++ - 1];
		return a;
	}

	// 75 chars
	int[] iteracion4(int[] a) {
		int s = 0, i = 0;
		for (int x : a) {
			s += x;
			a[i] = s;
			i++;
		}
		return a;
	}

	// Version final 69 chars (65 con globales sin inicializar)
	int[] iteracion5(int[] a) {
		int s = 0, i = 0;
		for (int x : a)
			a[i++] = s += x;
		return a;
	}
}
