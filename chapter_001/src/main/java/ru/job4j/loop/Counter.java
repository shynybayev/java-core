package ru.job4j.loop;

/**
 * Counter class
 */
public class Counter {

/** метод add которая суммирует четные числа в диапозоне от 1 до 10
	@param start - начала диапазона
	@param finish - конец диапазона
	@return возвращение суммы
*/
   
    public int add( int start,  int finish) {
        int count=0;
        for (int i = start; i <= finish; i++) {
            if ( i%2 == 0) {
                count += i;
            }
        }
        return count;
    }
}
