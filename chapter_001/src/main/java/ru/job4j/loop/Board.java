package ru.job4j.loop;

/**
* Class Board
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Board {

	/**
	* Метод рисующий шахматную доску из символов х и пробелов
	* @param width ширина доски
	* @param height высота доски
	* @return Рисунок шахматной доски
	*/
	public String paint(int width, int height) {
		StringBuilder screen = new StringBuilder();
		String ln = System.lineSeparator();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((j + i) % 2 == 0) {
					screen.append("X");
				} else {
					screen.append("a");
				}
  			}
			screen.append(ln);
		}
		return screen.toString();
	}
}