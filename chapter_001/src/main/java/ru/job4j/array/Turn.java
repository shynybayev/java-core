package ru.job4j.array;

import java.util.Arrays;

/**
* Class Turn
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Turn {

	/**
	* Метод который переворачивает массив задом наперёд
	* @param array массив
	* @return Перевернутый массив
	*/
	public int[] turn(int[] array) {
		int index = array.length - 1;

		for (int i = 0; i < array.length / 2; i++) {
			int temp = array[i];
  			array[i] = array[index - i];
  			array[index - i] = temp;
  		}
		return array;
	}

}