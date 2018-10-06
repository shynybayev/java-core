package ru.job4j.tracker;

import com.sun.jmx.snmp.tasks.Task;

import java.util.Arrays;
import java.util.Scanner;

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
    public StartUI( Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init(){
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)){
                this.createItem();
            } else if ("1".equals(answer)){
                 System.out.println(Arrays.toString(tracker.getAll()));
            } else if ("2".equals(answer)){
                this.replaceItem();
            } else if ("3".equals(answer)){
                this.deleteItem();
            } else if ("4".equals(answer)){
                this.findItemById();
            } else if ("5".equals(answer)){
                this.findItemByName();
            } else if (EXIT.equals(answer)){
                exit = true;
            }
        }
    }


    private void createItem() {
        System.out.println("- Добавление новой заявки -");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка с Id : " + item.getId());
    }

    private void replaceItem(){
        System.out.println("- Редактирования заявки -");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        tracker.replace(item.getId(), item);
        System.out.println("Новая заявка: " + item.getName());
    }

    private void deleteItem() {
        System.out.println("- Удаление заявки -");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        tracker.delete(item.getId());
        System.out.println("Заявки с ID: " + item.getId() + " была удалена");
    }


    private void findItemById() {
        System.out.println("- Поиск заявки по ID -");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        tracker.findById(item.getId());
        System.out.println("Имя заявки по ID: " + item.getName());
    }

    private void findItemByName(){
        System.out.println("- Поиск заявки по Имени -");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        tracker.findByName(name);
        System.out.println("Заявка по имени: " + item.getName());
    }

    private void showMenu(){
        System.out.println("Выберите пункт меню:\n " +
                    "0. Add new Item\n" +
                    "1. Show all items\n" +
                    "2. Edit item\n" +
                    "3. Delete item\n" +
                    "4. Find item by Id\n" +
                    "5. Find items by name\n" +
                    "6. Exit Program\n"
        );
    }

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        new StartUI(input,tracker ).init();
    }
}
