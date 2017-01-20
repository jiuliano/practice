package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/20/2017.
 */
public class BinarySearchTest {

    @Test
    public void test() {
        BinarySearch binarySearch = new BinarySearch();

        int list[] = new int[] { 1, 2, 3, 4, 5, 8, 12, 15, 17, 22, 23, 500, 501, 502 };

        int i = binarySearch.binarySearch(list, 17);
        assertEquals(i, 8);

        i = binarySearch.binarySearch(list, -5);
        assertEquals(i, -1);

        i = binarySearch.binarySearch(list, 900);
        assertEquals(i, -1);

        i = binarySearch.binarySearch(list, 5);
        assertEquals(i, 4);

        i = binarySearch.binarySearch(list, 1);
        assertEquals(i, 0);

        i = binarySearch.binarySearch(list, 502);
        assertEquals(i, list.length-1);

        i = binarySearch.binarySearch(list, 16);
        assertEquals(i, -1);
    }
}