package ru.job4j.pseudo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {
    //Получаем ссылку на стандартный вывод в консоль.
    private final PrintStream stdout = System.out;
    //Создаем буфeр для хранения вывода.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    //Заменяем стандартный вывод на вывод в пямять для тестирования.
    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    //Возвращаем обратно стандартный вывод в консоль.
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("****\n")
                                .append("****\n")
                                .append("****\n")
                                .append("****\n")
                                .append(System.lineSeparator())
                                .toString())
        );
    }

    @Test
    public void whenUserDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   *\n")
                                .append("  ***  \n")
                                .append(" ***** \n")
                                .append("******* \n")
                                .append(System.lineSeparator())
                                .toString())
        );
    }
}