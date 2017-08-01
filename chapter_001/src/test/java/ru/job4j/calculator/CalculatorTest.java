package ru.job4j.calculator;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author Assan Shynybayev
* @version 2.0
* @since 1.0
*/

public class CalculatorTest {

/**
* Тест на операцию сложения двух чисел.
*/
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
	
/**
* Тест на операцию вычитания двух чисел.
*/
	@Test
	public void whenSubstructOneMinusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.substruct(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }

/**
* Тест на операцию деления двух чисел.
*/	
	@Test
	public void whenDivOneDivideOneThenTwo() {
        Calculator calc = new Calculator();
        calc.div(6D, 2D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }
	
/**
* Тест на операцию умножения двух чисел.
*/	
	@Test
	public void whenMultipleOneMultiplyOneThenTwo() {
        Calculator calc = new Calculator();
        calc.multiple(2D, 3D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }
}
