package ru.job4j.tracker;

import java.util.Scanner;

/**
 * Класс система ввода и вывода
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */

public class ConsoleInput implements Input {
    private Scanner sc = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.print(question);
        return sc.nextLine();
    }

    @Override
    public void print(String data) {
        Tracker tracker = new Tracker();
        tracker.findById(data);
    }

}
