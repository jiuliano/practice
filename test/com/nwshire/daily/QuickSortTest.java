package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/19/2017.
 */
public class QuickSortTest {
    @Test
    public void quickSort() throws Exception {
        QuickSort quickSort = new QuickSort();

        String list[] = { "eggs", "bacon", "toast", "oj", "apples", "oranges", "tomatoes", "stringbeans", "ham" };
        quickSort.quickSort(list);

        String sList[] = { "apples", "bacon", "eggs", "ham", "oj", "oranges", "stringbeans", "toast", "tomatoes" };
        for ( int n=0; n<sList.length; n++ )
        {
            assertEquals(list[n], sList[n]);
        }
    }
}