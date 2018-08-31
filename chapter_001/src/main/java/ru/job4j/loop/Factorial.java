package ru.job4j.loop;

/**
* Class Factorial
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class Factorial{
	
	/**
	* Метод вычитывающий факториал числа
	* @param n число
	* @return Результат
	*/
	public static int calc(int n){
		int i = 1;
		int sum = 1;
		do {
			if (n == 0){
				return  1;
			}
			sum *= i;
			i++;
		} while (i <= n);
		return  sum;
	}
}