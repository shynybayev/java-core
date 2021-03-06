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

public class WrapperTest {
	
	@Test
	public void whenStartWithPrefixThenTrue() {
		Wrapper arrayChar = new Wrapper("Hello");
		boolean result = arrayChar.startWith("He");
		assertThat(result, is(true));
	}

	@Test
	public void whenNotStartWithPrefixThenFalse() {
		Wrapper arrayChar = new Wrapper("Hello");
		boolean result = arrayChar.startWith("Hi");
		assertThat(result, is(false));
	}
}