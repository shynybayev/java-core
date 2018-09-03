package ru.job4j.array;

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
			for (int j = 0; j < data.length; j++) {
				if (data[i][j] != data[i][j]) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}