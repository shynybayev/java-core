package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
* Test
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public  class  PointTest{
	@Test
	public void calculatingDistanceBetweenPoints(){
		Point a = new Point(0, 1);
		Point b = new Point(2, 5);
		double res = a.distanceTo(b);
		double expected = 4.47213595499958;
		assertThat(res, closeTo(expected,0.1));
	}

}