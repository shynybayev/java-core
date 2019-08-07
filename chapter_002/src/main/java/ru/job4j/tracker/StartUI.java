package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс - точка входа в приложение
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private boolean flagToExit = true;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы, вызывается в main
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionLength(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.selectKey(input.ask(" Select: ", range));
        } while (this.flagToExit);
    }

    public void stop() {
        this.flagToExit = false;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}