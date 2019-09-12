package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author <a href="mailto:shynybaev@gmail.com">Assan Shynybayev</a>
 * @version 1.0
 * @since 0.1
 */
public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0},
        };
        assertThat(result, is(expect));
    }

    @Test
    public void convertTest() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> toConvert = new ArrayList();
        toConvert.add(new int[]{1, 2});
        toConvert.add(new int[]{3, 4, 5, 6});
        assertThat(list.convert(toConvert), is(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

}