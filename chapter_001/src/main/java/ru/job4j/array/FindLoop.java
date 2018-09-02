package ru.job4j.array;

/**
* Class FindLoop
* @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
* @version 1.0
* @since 0.1
*/

public class FindLoop{
	public int indexOf(int[] data, int el){
		int rst = -1; //если элемента нет в массиве, то возврщаем -1

		for (int index = 0; index < data.length; index++) {
			if (data[index] == el) {
				rst = index;
				break;
			}
		}
		return rst;
	}
}