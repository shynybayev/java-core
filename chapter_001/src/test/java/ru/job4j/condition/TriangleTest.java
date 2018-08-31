package ru.job4j.condition;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.closeTo;


/**
* Test 
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class TriangleTest{
	@Test
	public void whenAreaSetThreePointsThenTriangleArea(){
		//создаем три объекта класса
		Point a = new Point(0, 0);
		Point b = new Point(0, 2);
		Point c = new Point(2, 0);

		//создаем объект треугольника и передаем в него объекты точек.
		Triangle triangle = new Triangle(a, b, c);
		
		//вычисляем площадь
		double result = triangle.area();

		//задаем ожидаемый результат
		double expected = 2D;

		//проверяем результат и ожидемое значение.
		assertThat(result, closeTo(expected, 0.1));
	}
}