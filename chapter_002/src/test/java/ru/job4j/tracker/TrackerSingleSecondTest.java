package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class TrackerSingleSecondTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        TrackerSingleSecond tracker = TrackerSingleSecond.getInstance();
        assertThat(tracker, is(tracker));
    }
}