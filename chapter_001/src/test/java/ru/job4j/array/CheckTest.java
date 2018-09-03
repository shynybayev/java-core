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

public class CheckTest {

	@Test
	public void whenDataMonoByTrueThenTrue(){
		Check check = new Check();
		boolean[] input = new boolean[]{true, true, true};
		boolean res = check.mono(input);
		assertThat(res, is(true));
	}

	@Test
	public void whenDataNotMonoByTrueThenFalse(){
		Check check = new Check();
		boolean[] input = new boolean[]{true, false, true};
		boolean res = check.mono(input);
		assertThat(res, is(false));
	}

	@Test
	public void whenDataWithOddAmountOfElements(){
		Check check = new Check();
		boolean[] input = new boolean[]{false, false, false};
		boolean res = check.mono(input);
		assertThat(res, is(true));
	}

	@Test
	public void whenDataWithEvenAmountOfElements(){
		Check check = new Check();
		boolean[] input = new boolean[]{true, false, true, false};
		boolean res = check.mono(input);
		assertThat(res, is(false));
	}

}
