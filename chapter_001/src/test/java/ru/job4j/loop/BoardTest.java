package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class BoardTest{
	@Test
	public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows(){
		Board board = new Board();
		String res = board.paint(3,3);
		final String line = System.getProperty("line.separator");
		String expected = String.format("XaX%saXa%sXaX%s", line, line, line);
		assertThat(res, is(expected));
	}

	@Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
    	Board board = new Board();
    	String res = board.paint(5,4);
    	final String line = System.getProperty("line.separator");
    	String expected = String.format("XaXaX%saXaXa%sXaXaX%saXaXa%s", line, line, line, line);
    	assertThat(res, is(expected));
    }

}