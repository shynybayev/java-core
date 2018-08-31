package ru.job4j.max;

/**
 * Класс Max
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */

public class Max{
	public int max(int first , int second){

	return first > second ? first : second;

	 }
	 
	public int max(int first, int second, int third){
	    return Math.max(first, Math.max(second, third));
	}
}