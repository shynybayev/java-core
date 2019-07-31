package ru.job4j.pseudo;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SquareTest {
    @Test
    public void whenUserPaintSquare() {
        Square square = new Square();
        assertThat(
                square.draw(), is(
                        new StringBuilder()
                                .append("****\n")
                                .append("****\n")
                                .append("****\n")
                                .append("****\n")
                        .toString()
                )
        );
    }
}