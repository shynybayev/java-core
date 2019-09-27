package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
* Test для программы расчета идеального веса.
* @author Assan Shynybayev
* @version 2.0
* @since 1.0
*/

public class FitTest {

	/**
	* Тест для вычисления идеального веса мужчины.
	*/
	@Test
	public void manWeight() {
		Fit fit = new Fit();
		double weight = fit.manWeight(180);
		assertThat(weight, closeTo(92.0, 0.1));
	}

	/**
	* Тест для вычисления идеального веса женщины.
	*/
	@Test
	public void womanWeight() {
		Fit fit = new Fit();
		double weight = fit.womanWeight(170);
		assertThat(weight, closeTo(69.0, 0.1));
	}
}