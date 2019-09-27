package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class MatrixCheckTest {

	@Test
	public void whenDataMonoByTrueThenTrue() {
		MatrixCheck matrixCheck = new MatrixCheck();
		boolean[][] input = new boolean[][]{
				{true, true, true},
				{false, true, true},
				{true, false, true}
		};
		boolean res = matrixCheck.mono(input);
		assertThat(res, is(true));
	}

	@Test
	public void whenDataNotMonoByTrueThenFalse() {
		MatrixCheck matrixCheck = new MatrixCheck();
		boolean[][] input = new boolean[][]{
				{true, false, true},
				{false, false, false},
				{true, false, true}
		};
		boolean res = matrixCheck.mono(input);
		assertThat(res, is(false));
	}

	@Test
	public void whenArrayWithOddAmountOfElementsThenFalse() {
		MatrixCheck matrixCheck = new MatrixCheck();
		boolean[][] input = new boolean[][]{
				{false, false, false},
				{true, true, true},
				{false, false, false}
		};
		boolean res = matrixCheck.mono(input);
		assertThat(res, is(false));
	}

	@Test
	public void whenArrayWithEvenAmountOfElementsThenTrue() {
		MatrixCheck matrixCheck = new MatrixCheck();
		boolean[][] input = new boolean[][]{
				{false, false, false, true},
				{true,  false, true,  true},
				{false, true, false,  false},
				{true,  true,  true,  false}
		};
		boolean res = matrixCheck.mono(input);
		assertThat(res, is(true));
	}

	@Test
	public void whenArrayWithEvenAmountOfElementsThenFalse() {
		MatrixCheck matrixCheck = new MatrixCheck();
		boolean[][] input = new boolean[][]{
				{false, false, false, false},
				{true,  false, true,  true},
				{false, true, false,  false},
				{true,  true,  true,  false}
		};
		boolean res = matrixCheck.mono(input);
		assertThat(res, is(false));
	}


}