package ru.job4j.factorial;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class FactorialTest 
 *
 * @author Assan Shynybayev
 * @version 1
 * @since 2.0
 */
 
public class FactorialTest {
    /**
     * Тест проверяющий, что факториал для числа 5 равен 120
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(5), is(120));

    }
	
    /**
     * Тест проверяющий, что факториал для числа 0 равен 1.
     */
	@Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factorial = new Factorial();
        assertThat(factorial.calc(0), is(1));

    }
}
