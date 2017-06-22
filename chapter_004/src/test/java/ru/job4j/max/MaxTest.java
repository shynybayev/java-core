package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstMoreThenSecond() {
		
		Max max = new Max();
		max.add(2D, 1D);
		
		int first = first.getResult();
		int expected = 2D;
		assertThat(result, is(expected));
	     
    }
	
	 public void whenFirstLessThenSecond() {
		
		Max max = new Max();
		max.add(1D, 2D);
		
		int second = second.getResult();
		int expected = 2D;
		assertThat(result, is(expected));
	     
    }
}