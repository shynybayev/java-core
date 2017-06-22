package ru.job4j.calculator;

/**
* Class Calculate решение задачи части 001 урок 1
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 2.0
* @since 1.0
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
	
	public double getResult(){
		return this.result;
	}
}