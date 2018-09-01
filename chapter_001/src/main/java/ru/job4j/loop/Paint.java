package ru.job4j.loop;

/**
* Class Paint
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Paint{
	public String pyramid(int height){
		StringBuilder str = new StringBuilder();
		int weight = 2 * height - 1;

		for (int row = 0; row != height; row++) {
			for (int column = 0; column != weight; column++) {
				if (row >= height - column - 1 && row + height - 1 >= column){
					str.append("^");
				} else {
					str.append(" ");
				}
			}
		str.append(System.lineSeparator());
		}

		return str.toString();
	}

	public String rightTrl(int height){
		StringBuilder str = new StringBuilder(); // Буфер для результата.
		int weight = height;	// ширина будет равна высоте.
		// внешний цикл двигается по строкам.
		for (int row = 0; row != height; row++) {
			// внутренний цикл определяет положение ячейки в строке.
			for (int column = 0; column != weight ; column++) {
				// если строка равна ячейки, то рисуем галку.
				// в данном случае строка определяем, сколько галок будет на строке
				if (row >= column) {
					str.append("^");	
				} else {
					str.append(" ");
				}
			}
			str.append(System.lineSeparator()); // добавляем перевод строки
		}
		return str.toString(); // Получаем результат
	}


	public String leftTrl(int height){
		StringBuilder str = new StringBuilder();
		int weight = height;

		for (int row = 0; row != height; row++) {
			for (int column = 0; column != weight; column++) {
				if (row >= weight - column - 1) {
					str.append("^");
				} else {
					str.append(" ");
				}
			}
			str.append(System.lineSeparator());
		}
		return str.toString();
	}
	
}