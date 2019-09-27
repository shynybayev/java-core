package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class SquareTest {

	@Test
	public  void  whenBound3Then149() {
		int bound = 3;
		Square sq = new Square();
		int[] res = sq.calculate(bound);
		int[] expected = new  int[]{1, 4, 9};
		assertThat(res, is(expected));
	}

}