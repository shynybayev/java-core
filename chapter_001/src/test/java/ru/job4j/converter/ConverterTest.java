package ru.job4j.converter;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test
* @author Assan Shynybayev
* @version 2.0
* @since 1.0
*/

public class ConverterTest {

/**
* Тест проверяющий конвертацию Тенге к Евро.
*/
	@Test
	public void when423TengeToEuroThen1() {
		Converter converter = new Converter();
 		int result = converter.tengeToEuro(423);
 		assertThat(result, is(1));
	}

/**
* Тест проверяющий конвертацию Тенге к Доллару.
*/
	@Test 
	public void when363TengeToDollarThen1() {
		Converter converter = new Converter();
 		int result = converter.tengeToDollar(363);
 		assertThat(result, is(1));
	}

/**
* Тест проверяющий конвертацию Евро к Тенге
*/
	@Test
	public void when1EuroToTengeThen423() {
		Converter converter = new Converter();
		int result = converter.euroToTenge(1);
		assertThat(result, is(423));
	}

/**
* Тест проверяющий конвертацию Доллара к Тенге.
*/
	@Test
	public void when1DollarToTengeThen363() {
		Converter converter = new Converter();
		int result = converter.dollarToTenge(1);
		assertThat(result, is(363));
	}

}	