package ru.job4j.tracker;

import java.util.List;

/**
 * Интерфейс
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> rang);
}