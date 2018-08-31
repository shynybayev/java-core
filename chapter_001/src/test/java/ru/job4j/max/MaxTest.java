package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Class MaxTest тестирует метод класса Max
* @author Assan Shynybayev
* @version 1.0
* @since 0.1
*/

public class MaxTest {
    /*
	*Тестирует метод max(int,int). Значение из первого параметра больше, чем второго. 
	*/
	@Test
    public void whenFirstMoreThenSecond() {
		
		Max max = new Max();
		int result = max.max(2, 1);
		int expected = 2;
		assertThat(result, is(expected));
	}
	/*
	*Тестирует метод max(int,int). Значение из первого параметра меньше, чем второго.
	*/
    @Test
    public void whenFirstLessThenSecond() {
        Max max = new Max();
        int result = max.max(1, 2);
        int expected = 2;
        assertThat(result, is(expected));
    }
	/*
	*Тестирует метод max(int,int,int). Определяет максимум значение из трех чисел
	*/
	@Test
		public  void whenZeroAndSixAndTwoThenSix() {
		Max maximum = new Max();
		assertThat(maximum.max(0, 6, 2), is(6));
	}

}