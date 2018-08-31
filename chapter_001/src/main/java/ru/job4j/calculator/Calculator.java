package ru.job4j.calculator;

/**
* Class Calculator
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Calculator {
	/*
	* Приватное поле result
	*/

	private double result;
	
	/*
	* Метод для выполнения операции сложения
	*/
	public void add(double first, double second){
		this.result = first + second;
	}
	
	/*
	* Метод для выполнения операции вычитания
	*/
	
	public void substruct(double first, double second){
		this.result = first - second;
	}
	
	/*
	* Метод для выполнения операции деления
	*/
	
	public void div(double first, double second){
		this.result = first / second;	
	}
	
	/*
	* Метод для выполнения операции умножения
	*/
 	public void multiple(double first, double second){
		this.result = first * second;
	}

	/**
	 * Метод для возвращения результата
	 * @return result
	 */
	public double getResult(){
		return this.result;
	}
}
