package ru.job4j.pseudo;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class EmptyShape implements Shape {
    @Override
    public String draw() {
        return " ";
    }
}
