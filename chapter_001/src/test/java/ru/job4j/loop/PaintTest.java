package ru.job4j.loop;

import org.junit.Test;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class PaintTest {
	@Test
	public void whenPyramidMain() {
		Paint paint = new Paint();
		String res = paint.pyramid(4);
		System.out.println(res);
		assertThat(res, is(
				new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
						.add("   ^   ")
						.add("  ^^^  ")
						.add(" ^^^^^ ")
                        .add("^^^^^^^")
                        .toString()
			)
        );
	}


	@Test
	public void whenPyramidRight() {
		Paint paint = new Paint();
		String res = paint.rightTrl(4);
		System.out.println(res);
		assertThat(res, is(
				new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
						.add("^   ")
						.add("^^  ")
						.add("^^^ ")
						.add("^^^^")
						.toString()
				)
			);
		}
	

	@Test
	public void whenPyramidLeft() {
		Paint paint = new Paint();
		String res = paint.leftTrl(4);
		System.out.println(res);
		assertThat(res, is(
				new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
						.add("   ^")
						.add("  ^^")
						.add(" ^^^")
						.add("^^^^")
						.toString()
		));
	}
}