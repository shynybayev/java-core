package ru.job4j.array;

import java.util.Arrays;

/**
* Class ArrayDublicate
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class ArrayDublicate {

	/**
	* The method removes duplicates text in the array
	* @param array array
	* @return Array without duplicate text
	*/
	public String[] remove(String[] array) {
		int unique = array.length;

		for (int out = 0; out < unique; out++) {
			for (int in = out + 1; in < unique; in++) {
				if (array[out].equals(array[in])) {
					array[in] = array[unique - 1];
					unique--;
					in--;
				}
			}
		}
		return Arrays.copyOf(array, unique);
	}
}