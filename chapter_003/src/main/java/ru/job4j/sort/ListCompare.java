package ru.job4j.sort;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int result = 0;

        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            if (o1.charAt(i) != o2.charAt(i)) {
                result = Character.compare(o1.charAt(i), o2.charAt(i));
            }
        }

        return result;
    }
}