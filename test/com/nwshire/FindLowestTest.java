package com.nwshire;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/18/2017.
 */
public class FindLowestTest {
    @Test
    public void findLowest() throws Exception {
        int test1[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int test2[] = new int[] { 4, 5, 6, 7, 1, 2, 3 };
        int test3[] = new int[] { 2, 3, 4, 5, 6, 7, 1 };
        int test4[] = new int[] { 7, 1, 2, 3, 4, 5, 6 };

        FindLowest findLowest = new FindLowest();

        int idx = findLowest.findLowest(test1);
        assertEquals(idx, 0);

        idx = findLowest.findLowest(test2);
        assertEquals(idx, 4);

        idx = findLowest.findLowest(test3);
        assertEquals(idx, 6);

        idx = findLowest.findLowest(test4);
        assertEquals(idx, 1);
    }
}