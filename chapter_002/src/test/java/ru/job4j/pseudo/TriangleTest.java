package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TriangleTest {
    @Test
    public void whenPrintTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(
                new StringBuilder()
                    .append("   *\n")
                    .append("  ***  \n")
                    .append(" ***** \n")
                    .append("******* \n")
                .toString()

        ));
    }
}