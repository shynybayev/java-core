package ru.job4j.condition;

	/**
	* Class Point.
	* @author Assan Shynybayev
	* @version 2.0
	* @since 1.0
	*/
public class Point {
	/** Координаты. */
	private int x, y;
	/**
	* Point с координатами x , y.
	* @param x координаты x
	* @param y координаты y
	*/
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	* @return координаты x.
	* @return координаты x.
	*/
	public int getX() {
		return this.x;
	}
	/**
	* @return координаты y.
	* @return координаты y.
	*/
	public int getY() {
		return this.y;
	}
	/**
	* Определить являетяся ли point частью графика функции y(x) = a * x + b
	* @param a первый аргумент
	* @param b второй аргумент
	* @return максимальное значение
	*/
	public boolean is(int a, int b) {
		return this.y == this.x * a + b;
	}
}

