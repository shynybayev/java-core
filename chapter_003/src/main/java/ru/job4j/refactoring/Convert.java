package ru.job4j.refactoring;

import java.util.*;

/**
 *  Convert class
 *  @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 *  @version 1.0
 *  @since 0.1
 */
public class Convert {

    public Convert(){
    }

    /**
     * Method to convert matrix array to list
     * @param array
     * @return converted List
     */
    List<Integer> convertMatrix2List(int[][] array) {
        List<Integer> result = new ArrayList<>();
        for (int[] tempArr: array) {
            for (int index: tempArr) {
                result.add(index);
            }
        }
        return result;
    }

    /**
     * Method to convert list to matrix array
     * @param list
     * @param rows
     * @return converted Matrix
     */
    public int[][] convertList2Matrix(List<Integer> list, int rows) {
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
}