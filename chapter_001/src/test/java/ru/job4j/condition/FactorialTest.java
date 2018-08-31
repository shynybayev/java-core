package ru.job4j.condition;
import org.junit.Test;
import ru.job4j.loop.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
* Test 
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class FactorialTest{

	/**
	* Тест на вычисления факториала пяти
	*/
	@Test
	public void factorialNumberFive(){
		Factorial factorial = new Factorial();
		int input = factorial.calc(5);
		int expected = 120;
		assertThat(input,is(expected));
	}

	/**
	* Тест на вычисления факториала трех
	*/
	@Test
	public void factorialNumberThree(){
		Factorial factorial = new Factorial();
		int input = factorial.calc(3);
		int expected = 6;
		assertThat(input, is(expected));
	}
}