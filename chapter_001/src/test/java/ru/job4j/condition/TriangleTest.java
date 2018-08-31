package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

	/**
	* Test.
	*
	* @author Assan Shynybayev
	* @version 2.0
	* @since 1.0
	*/
public class TriangleTest {
	@Test
	public  void whenNoExistTriangleThenZero() {
		assertThat(areaTest(0, 0, 1, 1, 2, 2), closeTo(0, 0.01));
	}
	@Test
	public void whenExistTriangleThenAreaSix() {
		assertThat(areaTest(0, 1, 3, 1, 2, 5), closeTo(6, 0.01));
	}
    @Test
    public void whenExistTriangleAgainThenAreaNine() {
            assertThat(areaTest(5, 1, 3, 6, 7, 5), closeTo(9, 0.01));
    }
	/**
	* Тест метода.
	* @return возврат Triangle area
	*/
	private double areaTest(int ax, int ay, int bx, int by, int cx, int cy) {
				Triangle triangle = new Triangle(new Point(ax, ay),
									new Point(bx, by),
									new Point(cx, cy));
				return triangle.area();
	}
}
