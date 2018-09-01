package ru.job4j.loop;

/**
 * Class Counter
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */

public class Counter {

    /**
     * Метод подсчета суммы четных чисел в диапазоне
     * @param start первое число
     * @param finish второе число
     * @return Сумма четных чисел
     */
    public  static int add(int start, int finish){
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (start%2 == 0) {
                sum += start;
            }
        }
        return sum;
    }
}
