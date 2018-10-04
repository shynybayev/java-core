package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem(){
        Tracker tracker = new Tracker();
        Item item = new Item("testId", "testName", 123L);
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName(){
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        //Добавляем заявку в трекер. Теперь в объект проиницолизирован ID
        tracker.add(previous);
        //Создаем новую заявку
        Item newItem = new Item("test2", "testDescription2", 1234L);
        //Проставляем старый Id из previous, который  был сгенирирован выше
        newItem.setId(previous.getId());
        //Обновляем заявку в трекере
        tracker.replace(previous.getId(), newItem);
        //Проверяем что заявка с таким ID имеет новое имя test2
        assertThat(tracker.findById(previous.getId()).getName(), is("testDescription2"));
    }

    @Test
    public void whenFindByNameThenReturnItemWithGetName(){
        Tracker tracker = new Tracker();
        Item item = new Item("testId", "testName", 123L);
        tracker.add(item);

        Item item2 = new Item("testId2", "testName", 1234L);
        String input =  item2.getName();

        Item[] result = tracker.findByName(input);

        Item[] expected = new Item[]{item};
        assertThat(result,is(expected));
     }

    @Test
    public void whenDeleteItemFindByIdI(){
        Tracker tracker = new Tracker();
        Item first = new Item("testId", "testName", 123L);
        tracker.add(first);
        Item second = new Item("testId2", "testName", 212L);
        tracker.add(second);

        Item[] array = new Item[1];
        array[0] = second;

        tracker.delete(first.getId());
        assertThat(array, is(tracker.getAll()));
    }

    @Test
    public void whenFindByIdThenReturnItemFoundId(){
        Tracker tracker = new Tracker();
        Item item = new Item("testId", "testName", 122L);
        Item itemNull = null;

        tracker.add(item);
        Item result = tracker.findById(item.getId());

        if (result != null){
            assertThat(result, is(item));
        } else {
            assertThat(result, is(itemNull));
        }

    }

    @Test
    public void whenGetAllItemsCopyWithoutNullElements(){
        Tracker tracker = new Tracker();
        Item item = new Item("testId", "testName", 213L);

        tracker.add(item);
        Item[] result = tracker.getAll();
        Item[] expected = new Item[]{item};
        assertThat(result, is(expected));
    }
}
