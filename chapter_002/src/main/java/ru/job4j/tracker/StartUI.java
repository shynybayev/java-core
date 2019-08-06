package ru.job4j.tracker;

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

    /**
     * значени которое поулчаем из меню
     */
    private int[] ranges = new int[]{1, 2, 3, 4};

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
        menu.fillActions(this);

        do {
            menu.show();
            int key = Integer.valueOf(this.input.ask("Select: "));
            menu.selectKey(key);
//            menu.selectKey(input.ask(" Select: ", ranges));
        } while (this.flagToExit);
    }

    public void stop() {
        this.flagToExit = false;
    }

    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}