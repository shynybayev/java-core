package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.lang.String;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu = new StringBuilder()
                .append("Choose action:\n ")
                .append("0. Add the new Item\n")
                .append("1. Show all items\n")
                .append("2. Update item\n")
                .append("3. Delete item by ID\n")
                .append("4. Find item by ID\n")
                .append("5. Find items by name\n")
                .append("6. Exit Program\n")
                .append("Select:\n")
                .append(System.lineSeparator())
                .toString();


    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker(); //создаем объект класса Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"}); //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init(); //создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdateValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "test description", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteItemByID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenUserFindItemByIDThenTrackReturnItemWithTheSameID() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenUserFindItemByNameThenTrackerReturnItemWithTheSameName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Item[] items = new Item[1];
        items[0] = item;
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findByName(item.getName()), is(items));
    }

    @Test
    public void whenUserClickToAddItem() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu + "- Adding the new item -" + System.lineSeparator()
                        + "-New Item with Id : " + tracker.findAll()[0].getId() + System.lineSeparator()
                        + "-New Item with Name : " + tracker.findAll()[0].getName() + System.lineSeparator()
                        + "-New Item with Description : " + tracker.findAll()[0].getDesc() + menu)
        );
    }

    @Test
    public void whenUseClickToShowAllItems() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"1", "6"});
        Item[] items = new Item[]{item};
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu + Arrays.toString(items) + System.lineSeparator()
                        + menu
        ));
    }

    @Test
    public void whenUseChooseToReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"2", item.getId(), "test2", "desc2", "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu + "- Редактирования заявки -" + System.lineSeparator()
                        + "Заявка по ID : " + item.getId() + " обновлена" + System.lineSeparator() + menu
        ));
    }

    @Test
    public void whenUserChooseToDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu + "- Удаление заявки -" + System.lineSeparator()
                + "Заявки с ID: " + item.getId() + " была удалена" + System.lineSeparator() + menu
        ));
    }

    @Test
    public void whenUserChooseToFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu + "- Поиск заявки по ID -" + System.lineSeparator()
                        + "Имя заявки по ID: " + item + System.lineSeparator() + menu
        ));
    }

    @Test
    public void whenUserChooseToFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", 123L));
        Input input = new StubInput(new String[]{"5", item.getName(), "6"});
        Item[] items = new Item[]{item};
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()), is(
                menu + "- Поиск заявки по Имени -" + System.lineSeparator() + "Заявка по имени: " + item.getName() + " : "
                + Arrays.toString(items) + System.lineSeparator() + menu
        ));
    }
}