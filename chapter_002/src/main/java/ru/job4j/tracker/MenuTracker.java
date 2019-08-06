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
    private List<UserAction> actions = new ArrayList<>(); //массив действий
    private static final int ADD = 0;
    private static final int EXIT = 6;

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
    public int getActionLength(){
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(this.input, this.tracker));         //в качестве заполнения используем внетренний класс
        this.actions.add(new ShowItems(this.input, this.tracker));
        this.actions.add(new EditItem(this.input, this.tracker));
        this.actions.add(new DeleteItem(this.input, this.tracker));
        this.actions.add(new FindItemByID(this.input, this.tracker));
        this.actions.add(new FindItemByName(this.input, this.tracker));
        this.actions.add(new ExitProgram(this.input, this.tracker));
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
            if (action!=null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {
        private Input input;
        private Tracker tracker;

        public AddItem(Input in, Tracker tr){
            input = in;
            tracker = tr;
        }

        @Override
        public int key() {
            return ADD;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new Item"); //возвращает строку содержащее 0. Add the new Item
        }
    }

    private class ShowItems implements UserAction {
        private Input input;
        private Tracker tracker;

        public ShowItems(Input input, Tracker tracker){
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item: tracker.findAll()) {
                System.out.println("Item id: " + item.getId() + " Name: " + item.getName() + " Description: " + item.getDesc());
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items");
        }
    }

    private class EditItem implements UserAction {
        private Input input;
        private Tracker tracker;

        public EditItem(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Update item");
        }
    }

    private class DeleteItem implements UserAction {

        private Input input;
        private Tracker tracker;

        public DeleteItem(Input in, Tracker tr){
            this.input = in;
            this.tracker = tr;
        }

        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item by ID"); //возвращает строку содержащее 0. Add the new Item
        }
    }

    private class FindItemByID implements UserAction {
        private Input input;
        private Tracker tracker;

        public FindItemByID(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("- Find item by id -");
            String id = input.ask("Please, enter the task ID : ");
            Item byID = tracker.findById(id);
            System.out.println("Found item by id : " + byID);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by ID"); //возвращает строку содержащее 0. Add the new Item
        }
    }

    private class FindItemByName implements UserAction {
        private Input input;
        private Tracker tracker;

        public FindItemByName(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("- Find item by name -");
            String name = input.ask("Please, enter the task name: ");
            Item[] byName = tracker.findByName(name);
            System.out.println("Item by name: " + name + " : " + Arrays.toString(byName));
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find item by name");
        }
    }

    private class ExitProgram implements UserAction {
        private Input input;
        private Tracker tracker;

        public ExitProgram(Input input, Tracker tracker) {
            this.input = input;
            this.tracker = tracker;
        }

        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Program is closed");
            System.exit(0);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Exit program");
        }
    }
}