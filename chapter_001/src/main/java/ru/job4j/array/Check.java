package ru.job4j.array;

/**
* Class Check
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Check {

	public boolean mono(boolean[] data) {
		boolean result = true;

		for (int i = 0; i < data.length; i++) {
			if (data[0] != data[i]) {
				result = false;
				break;
			}
		}
		return result;
	}

}