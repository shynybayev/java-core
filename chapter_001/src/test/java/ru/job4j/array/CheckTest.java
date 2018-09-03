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
		Check ch = new Check();
		boolean[] input = new boolean[]{true, true, true};
		boolean res = ch.mono(input);
		boolean expected = true;
		assertThat(res, is(expected));
	}

	@Test
	public void whenDataNotMonoByTrueThenFalse(){
		Check ch = new Check();
		boolean[] input = new boolean[]{true, false, true};
		boolean res = ch.mono(input);
		boolean expected = false;
		assertThat(res, is(expected));
	}

	@Test
	public void whenDataNotMonoByFalseThenTrue(){
		Check ch = new Check();
		boolean[] input = new boolean[]{false, false, false};
		boolean res = ch.mono(input);
		boolean expected = true;
		assertThat(res, is(expected));
	}

}
