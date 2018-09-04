package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class ArrayDublicateTest{

	@Test
	public void whenArrayDublicateTest(){
		ArrayDublicate arrayDublicate = new ArrayDublicate();
		String[] input = {"Hello", "Hi", "Salute", "Hi", "Privet", "Hello"};
		String[] result = arrayDublicate.remove(input);
		String[] expected = {"Hello", "Hi", "Salute", "Privet"};
		assertThat(result, arrayContainingInAnyOrder(expected));
	}
}