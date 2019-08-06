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

    /**
     * Метод вывода вопроса, возвращает оператор ввода строки с консоли
     * @param question вопрос
     * @return оператор ввода с консоли
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return sc.nextLine();
    }
}