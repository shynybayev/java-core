package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ValidateInputTest {
    private final ByteArrayOutputStream memory = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMemory() {
        System.setOut(new PrintStream(this.memory));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidValue() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"invalid", "1"})
        );
        List<Integer> integer = new ArrayList<>();
        integer.add(1);
        input.ask("Enter", integer);
        assertThat(
                this.memory.toString(),
                is(
                        String.format("Wrong input, please enter validate data again! " + System.lineSeparator())
                )
        );
    }
}