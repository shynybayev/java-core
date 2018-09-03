package ru.job4j.array;

import java.util.Arrays;

/**
* Class MatrixCheck
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class MatrixCheck{
	public boolean mono(boolean[][] data){
		boolean result = true;

		for (int i = 0; i < data.length; i++) {
			if ((data[i][i] != data[0][0]) | (data[i][i] != data[1][1]) | (data[i][i] != data[2][2])){
				result = false;
				break;
			}
		}
		return result;
	}
}