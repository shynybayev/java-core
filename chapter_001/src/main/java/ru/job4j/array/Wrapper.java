package ru.job4j.array;

/**
* Обертка над строкой
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a> 
* @version 1.0
* @since 0.1
*/

public class Wrapper {
	private char[] data;

	public Wrapper(String line) {
		this.data = line.toCharArray();
	}

	/**
	* Проверяет что слово начинается с префикса
	* @param prefix префикс
	* @return если слово начинается с префикса
	*/
	public boolean startWith(String prefix) {
		boolean result = true;
		char[] value = prefix.toCharArray();

		for (int i = 0; i < value.length; i++) {
			if (value[i] != data[i]) {
				result = false;
				break;
			}  
		}

		return result;
	}

}