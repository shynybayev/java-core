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

public class MatrixTest{
	@Test
	public void whenMatrix(){
		Matrix matrix = new Matrix();
		int[][] input = matrix.multiple(2);
		int[][] expected = { 
				{1, 2}, 
				{2, 4} 
		};
		assertThat(input, is(expected));
	}
}