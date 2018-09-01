package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author Assan Shynybayev
 * @version 2.0
 * @since 1.0
 */

public class CounterTest {

    /**
     * Тест для сравнения сумму четных чисел в диапозоне
     */
    @Test
    public void whenCounterIsTrue() {
        Counter counter = new Counter();
        assertThat( 30, is( counter.add(1, 10)));
    }
}
