package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class TrackerSingleFourthTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        TrackerSingleFourth tracker = TrackerSingleFourth.getInstance();
        Item item = new Item("item name", "item desc", 123L);
        tracker.add(item);
        assertThat(tracker.findAll()[0], is(item));
    }

}