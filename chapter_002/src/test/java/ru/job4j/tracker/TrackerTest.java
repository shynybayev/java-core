package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("testId", "testName", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous); //Добавляем заявку в трекер. Теперь в объектe проинициализирован ID
        //Создаем новую заявку
        Item newItem = new Item("test2", "testDescription2", 1234L);
        //Проставляем старый Id из previous, который  был сгенирирован выше
        newItem.setId(previous.getId());
        //Обновляем заявку в трекере
        tracker.replace(previous.getId(), newItem);
        //Проверяем что заявка с таким ID имеет новое имя test2
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindByNameThenReturnItemWithGetName() {
        Tracker tracker = new Tracker();
        Item item = new Item("someName", "testDesc", 123L);
        tracker.add(item);
        Item item2 = new Item("someName", "someDesc", 1234L);
        String input =  item2.getName();
        ArrayList<Item> result = tracker.findByName(input);
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);

        assertThat(result, is(expected));
    }

    @Test
    public void whenDeleteItemFindById() {
        Tracker tracker = new Tracker();
        Item first = new Item("someName", "testName", 123L);
        tracker.add(first);
        Item second = new Item("someName", "testName", 1234L);
        tracker.add(second);
        ArrayList<Item> arrayList = new ArrayList<>();
        arrayList.add(0, second);
        tracker.delete(first.getId());

        assertThat(arrayList, is(tracker.findAll()));
    }

    @Test
    public void whenFindByIdThenReturnItemFoundId() {
        Tracker tracker = new Tracker();
        Item item = new Item("someName", "someDescription", 123L);
        tracker.add(item);
        Item result = tracker.findById(item.getId());

        if (result != null) {
            assertThat(result, is(item));
        } else {
            assertNull(result);
        }
    }

    @Test
    public void whenGetAllItemsCopyWithoutNullElements() {
        Tracker tracker = new Tracker();
        Item item = new Item("someName", "someDescription", 123L);
        tracker.add(item);
        ArrayList<Item> result = tracker.findAll();
        ArrayList<Item> expected = new ArrayList<>();
        expected.add(item);

        assertThat(result, is(expected));
    }
}
