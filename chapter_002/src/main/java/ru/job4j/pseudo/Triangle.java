package ru.job4j.pseudo;

/**
 * Класс треугольника.
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class Triangle implements Shape {
    @Override
    public String draw() {
        StringBuilder triangle = new StringBuilder();
        triangle.append("   *\n");
        triangle.append("  ***  \n");
        triangle.append(" ***** \n");
        triangle.append("******* \n");
        return triangle.toString();
     }
}
