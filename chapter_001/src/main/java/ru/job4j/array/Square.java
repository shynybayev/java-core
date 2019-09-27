package ru.job4j.array;

import java.util.Arrays;

/**
* Class Square
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Square {
	public int[] calculate(int bound) {
		int[] rst = new int[bound];
		int index = 1;
 		for (int i = 0; i < bound; i++) {
			rst[i] = (int) Math.pow(index++, 2);
		}
		return rst;
	}

}