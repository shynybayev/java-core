package ru.job4j.tracker;

import java.util.Arrays;

/**
 * Класс - точка входа в приложение
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    private StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы, вызывается в main
     */
    private void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if ("1".equals(answer)) {
                System.out.println(Arrays.toString(tracker.findAll()));
            } else if ("2".equals(answer)) {
                this.replaceItem();
            } else if ("3".equals(answer)) {
                this.deleteItem();
            } else if ("4".equals(answer)) {
                this.findItemById();
            } else if ("5".equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }


    private void createItem() {
        System.out.println("- Добавление новой заявки -");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        long created = System.currentTimeMillis();
        Item item = new Item(name, desc, created);
        this.tracker.add(item);
        System.out.println("Новая заявка " + item + " создана");
    }

    private void replaceItem() {
        System.out.println("- Редактирования заявки -");
        String id = this.input.ask("Введите ID заявки: ");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        long created = System.currentTimeMillis();
        Item item = new Item(id, name, desc, created);
        boolean result = tracker.replace(item.getId(), item);
        if (result) {
            System.out.println("Заявка по ID : " + id + " обновлена");
        } else {
            System.out.println("Заявка по ID : " + id + " не найдено");
        }
    }

    private void deleteItem() {
        System.out.println("- Удаление заявки -");
        String id = this.input.ask("Введите id заявки : ");
        boolean isDelete = tracker.delete(id);
        if (isDelete) {
            System.out.println("Заявки с ID: " + id + " была удалена");
        } else {
            System.out.println("Заявка с такой ID: " + id + " не существует");
        }
    }


    private void findItemById() {
        System.out.println("- Поиск заявки по ID -");
        String id = this.input.ask("Введите ID заявки : ");
        Item byID = tracker.findById(id);
        System.out.println("Имя заявки по ID: " + byID);
    }

    private void findItemByName() {
        System.out.println("- Поиск заявки по Имени -");
        String name = this.input.ask("Введите имя заявки: ");
        Item[] byName = tracker.findByName(name);
        System.out.println("Заявка по имени: " + name + " : " + Arrays.toString(byName));
    }

    private void showMenu() {
        System.out.println("Выберите пункт меню:\n "
                + "0. Add new Item\n"
                + "1. Show all items\n"
                + "2. Edit item\n"
                + "3. Delete item\n"
                + "4. Find item by Id\n"
                + "5. Find items by name\n"
                + "6. Exit Program\n"
        );
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
