package ru.job4j.list;


import java.util.ArrayList;
import java.util.Iterator;
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
        Iterator<Integer> iterator = list.iterator();
        int cells = list.size() / rows + (list.size() % rows == 0 ? 0 : 1);
        int[][] result = new int[rows][cells];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cells; j++) {
                if (iterator.hasNext())
                    result[i][j] = iterator.next();
                else
                    result[i][j] = 0;
            }
        }
        return result;
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
