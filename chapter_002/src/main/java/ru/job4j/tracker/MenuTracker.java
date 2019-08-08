package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс - консольное меню
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */

public class MenuTracker {
    /**
     * @param хранит ссылку на объект
     */
    private Input input;
    /**
     * @param хранит ссылку на объект
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>(); //список действий
    private int position = 0;

    /**
     * Конструктор.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(position++, new AddItem(0, "Add a new item"));
        this.actions.add(position++, new ShowItems(1, "Show all items"));
        this.actions.add(position++, new EditItem(2, "Update item"));
        this.actions.add(position++, new DeleteItem(3, "Delete item by ID"));
        this.actions.add(position++, new FindItemByID(4, "Find item by ID"));
        this.actions.add(position++, new FindItemByName(5, "Find item by name"));
        this.actions.add(position++, new ExitProgram(ui, 6, "Exit program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void selectKey(int key) {
        this.actions.get(key).execute(input, tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        System.out.println("Choose action:");
        for (UserAction action: actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("- Adding the new item -");
            String name = input.ask("Please, enter the task name: ");
            String description = input.ask("Please, enter the task description: ");
            long created = System.currentTimeMillis();
            Item item = new Item(name, description, created);
            tracker.add(item);
            System.out.println("-New Item with Id : " + item.getId());
            System.out.println("-New Item with Name : " + item.getName());
            System.out.println("-New Item with Description : " + item.getDesc());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items.length > 0) {
                for (Item item: tracker.findAll()) {
                    System.out.println("Item id: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc());
                }
            } else {
                System.out.println("List of items is empty");
            }
        }
    }

    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("- Updating item -");
            String id = input.ask("Please, enter the task ID: ");
            String name = input.ask("Please, enter the new task name: ");
            String description = input.ask("Please, enter the new task description: ");
            long created = System.currentTimeMillis();
            Item freshItem = new Item(name, description, created);
            boolean isReplaced =  tracker.replace(id, freshItem);
            if (isReplaced) {
                System.out.println("The task with ID: " + freshItem.getId() + " has updated");
            } else {
                System.out.println("The task with ID: " + freshItem.getId() + " not found");
            }
        }
    }

    private class DeleteItem extends BaseAction {


        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("- Deleting item -");
            String id = input.ask("Please, enter the task ID: ");
            boolean isDelete = tracker.delete(id);
            if (isDelete) {
                System.out.println("The task with ID: " + id + " has deleted");
            } else {
                System.out.println("The task with ID: " + id + " not found");
            }
        }
    }

    private class FindItemByID extends BaseAction {

        public FindItemByID(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("- Find item by id -");
            String id = input.ask("Please, enter the task ID : ");
            Item byID = tracker.findById(id);
            System.out.println("Found item by id : " + byID);
        }
    }

    private class FindItemByName extends BaseAction {

        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("- Find item by name -");
            String name = input.ask("Please, enter the task name: ");
            Item[] byName = tracker.findByName(name);
            System.out.println("Item by name: " + name + " : " + Arrays.toString(byName));
        }
    }

    private class ExitProgram extends BaseAction {
        private final StartUI ui;
        public ExitProgram(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Program is closed");
            this.ui.stop();
        }
    }
}