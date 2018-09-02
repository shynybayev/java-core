package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindLoopTest{
	
	@Test
	public void whenArrayHasLength5Then0(){
		FindLoop find = new FindLoop();
		int[] data = new int[]{5, 10, 3};
		int el = 5;
		int result = find.indexOf(data, el);
		int expected = 0;
		assertThat(result, is(expected));
	}
}