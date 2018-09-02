package ru.job4j.condition;

/**
 * Class Triangle.
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 2.0
 */

public class Point{

	/**
	* Координаты
	* @param x координата х
	* @param y координата y
	*/
	private int x;
	private int y;

	/**
	* Конструктор
	*/
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}

	/**
	* Метод вычисляющий расстояние между точками
	*/
	public double distanceTo(Point that){
		return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
	}
}