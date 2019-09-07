package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] tempArr: array) {
            for (int index: tempArr) {
                list.add(index);
            }
        }
        return list;
    }
}
