package ru.job4j.condition;

/**
* Класс Triangle
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Triangle{
	/**
	* Точки треугольника
	*/
	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	* Метод вычисляющий полупериметр по длинам сторон.
	*
	* @param ab расстояние между точками a b
	* @param ac расстояние между точками a c
	* @param bc расстояние между точками b c 
	* @return Перимент.
	*/

	public double period(double ab, double ac, double bc){
		double p = (ab + ac + bc)/2.0;
		return p;
	}

	/**
	* Метод должен вычислять площадь треугольника
	* @return Вернуть площадь, если треугольник существует или -1, если треугольника нет.
	*/
	public double area(){
		double rsl = -1.0; //Мы устанавливаем значение -1, так как может быть что треугольника нет. Это значение говорит о том, что треугольника нет.
		double ab = this.a.distanceTo(this.b);
		double ac = this.a.distanceTo(this.c);
		double bc = this.b.distanceTo(this.c);
		double p = this.period(ab, ac , bc);
		if (this.exist(ab, ac, bc)) {
			// формула для расчета площади треугольника
			rsl = Math.sqrt(p * (p - ab) * (p - ac) - (p - bc)); // формула Герона с переменными ab, ac, bc , p.

		}
		return rsl;
	}

	/**
	* Метод проверяет можно ли построить треугольник с такими длинами сторон.
	* 
	* @param ab Длина точки a b
	* @param ac Длина точки a c
	* @param bc Длина точки bc
	* @return
	*/
	private boolean exist(double ab, double ac, double bc){
		return ab > 0.0 && ac > 0.0 & bc > 0.0 ? true : false;
	}

}