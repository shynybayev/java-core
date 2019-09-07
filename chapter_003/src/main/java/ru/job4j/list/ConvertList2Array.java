package ru.job4j.list;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        List<Integer> newlist = new LinkedList<>();
        newlist.addAll(list);

        int cells = rows;
        int[][] array = new int[rows][cells];
        int index = 0;

        while (newlist.size() % rows != 0) {
            newlist.add(list.size(), 0);
        }

        for (int[] temp: array) {
            for (int i = 0; i < temp.length; i++) {
                temp[i] = newlist.get(index++);
            }
        }

        return array;
    }
}
