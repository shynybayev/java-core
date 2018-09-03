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

public class TurnTest{

	@Test
	public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray(){
		Turn turn = new Turn();
		int[] input = new int[]{1, 5, 2, 10};
		int[] result = turn.turn(input);
		int[] expected = new int[]{10, 2, 5, 1};
		assertThat(result, is(expected));
	}
}