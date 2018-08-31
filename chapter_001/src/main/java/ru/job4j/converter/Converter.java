package ru.job4j.converter;

/**
* Конвертер валюты
* @author Assan Shynybayev
* @version 2.0
* @since 1.0
*/

public class Converter{
	/**
	* Конвентируем Тенге в Евро
	* @param value Тенге
	* @return Евро
	*/

	public int tengeToEuro(int value){
		return 423 / value;
	}

	/**
	* Конвентируем Тенге в Доллары
	* @param value Тенге
	* @return Доллары
	*/

	public int tengeToDollar(int value){
		return 363 / value;
	}

	/**
	* Конвентируем Евро в Тенге
	* @param value Евро
	* @return Тенге
	*/

	public int euroToTenge(int value){
		return value * 423;
	}

	/**
	* Конвентируем Доллары в Тенге
	* @param value Доллары
	* @return Тенге
	*/

	public int dollarToTenge(int value){
		return value * 363;
	}
}