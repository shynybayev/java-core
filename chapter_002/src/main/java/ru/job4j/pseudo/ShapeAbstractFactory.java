package ru.job4j.pseudo;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public interface ShapeAbstractFactory {
    Triangle createTriangle();
    Square creatSquare();
    EmptyShape createEmpty();
}
