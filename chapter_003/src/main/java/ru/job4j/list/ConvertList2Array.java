package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class ConvertList2Array {
    /**
     * Конвертация списка в двумерный массив
     * @param list список
     * @param rows столбцы
     * @return двумерный массив
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;

        if (cells != 0) {
            cells += 1;
        }

        int[][] array = new int[rows][cells];
        int index = 0;

        for (int[] tempArray: array) {
            for (int i = 0; i < cells; i++) {
                tempArray[i] = index < list.size() ? list.get(index) : 0;
                index++;
            }
        }

        return array;
    }


    public List<Integer> convert(List<int[]> listOfArray) {
        List<Integer> result = new ArrayList<>();

        for (int[] array : listOfArray) {
            for (int i : array) {
                result.add(i);
            }
        }
        return result;
    }
}
