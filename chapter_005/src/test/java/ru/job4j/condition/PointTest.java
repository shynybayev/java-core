package ru.job4j.condition;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

	/**
	* Test.
	*
	* @author Assan Shynybayev
	* @version 2.0
	* @since 1.0
	*/
public class PointTest {
	@Test
	public  void whenZeroPointToTwoandThreeThenFalse() {
		Point point = new Point(0, 0);
		assertThat(point.is(2, 3), is(false));
	}
	@Test
	public  void whenTwoFivePointToOneAndThreeThenTrue() {
		Point point = new Point(2, 5);
		assertThat(point.is(1, 3), is(true));
	}
}
