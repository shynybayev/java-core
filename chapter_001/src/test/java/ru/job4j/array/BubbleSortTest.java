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

public class BubbleSortTest {
	
	@Test
	public void whenSortAnArray() {
		BubbleSort bubbleSort = new BubbleSort();
		int[] input = new int[]{2, 4, 1, 5, 3};
		int[] result = bubbleSort.sort(input);
		int[] expected = new int[]{1, 2, 3, 4, 5};
		assertThat(result, is(expected));
	}

}
