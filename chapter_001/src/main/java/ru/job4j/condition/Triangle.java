package ru.job4j.condition;

/**
 * Class Triangle.
 * @author Assan Shynybayev
 * @version 2.0
 * @version 1.0
 */
public class Triangle {
    /** Точки вершины Triangle*/
    private Point a, b, c;
    /**
     * Triangle с вершинами   a, b, c.
     * @param a вершины a
     * @param b вершины b
     * @param c вершины c
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    /** Метод вычисления площади  Triangle
	* Вычисляем вектора
	@return метод Math.abs() возвращает абсолютное значение  площади или  ноль если  не существует Triangle

	*/
    public double area() {
        Point vectorAB = new Point(this.b.getX() - this.a.getX(),this.b.getY() - this.a.getY());
        Point vectorAC = new Point(this.c.getX() - this.a.getX(),this.c.getY() - this.a.getY());
        return  Math.abs(vectorAB.getX()*vectorAC.getY()-vectorAB.getY()*vectorAC.getX())/2;
    }
}
