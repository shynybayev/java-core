package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * CounterTest class
 */
public class CounterTest {
    /** 
     * тестирование сложение суммы четных элементов
     */
	@Test
    public void whenCounterIsTrue() {
        Counter counter = new Counter();
        assertThat( 30, is( counter.add(1, 10)));
    }
}
