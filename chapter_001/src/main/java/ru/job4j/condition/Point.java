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


	public static void main(String[] args) {
		Point a = new Point(0, 1);
		Point b = new Point(2, 5);
		double result = a.distanceTo(b);
		System.out.println("Расстояние между точками А и В : " + result);
	}

}