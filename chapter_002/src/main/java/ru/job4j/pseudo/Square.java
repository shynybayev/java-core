package ru.job4j.pseudo;

/**
 * Класс для квадрата.
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class Square implements Shape {
    @Override
    public String draw() {
        StringBuilder square = new StringBuilder();
        square.append("****\n");
        square.append("****\n");
        square.append("****\n");
        square.append("****\n");
        return square.toString();
    }
}
