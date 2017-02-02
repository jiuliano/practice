package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 2/2/2017.
 */
public class SortColorsTest {
    @Test
    public void sortColors() throws Exception {
        SortColors sc = new SortColors();
        int[] test;

        test = new int[] { 2, 1, 1, 0, 2, 1, 1, 2, 2, 0, 0, 1 };
        sc.sortColors(test);
        assertSorted(test);

        test = new int[] { 2, 1, 0 };
        sc.sortColors(test);
        assertSorted(test);

        test = new int[] { 0, 0, 1 };
        sc.sortColors(test);
        assertSorted(test);

        test = new int[] { 1, 0, 2 };
        sc.sortColors(test);
        assertSorted(test);

        test = new int[] { 0 };
        sc.sortColors(test);
        assertSorted(test);

        test = new int[] { 1, 0 };
        sc.sortColors(test);
        assertSorted(test);
    }

    private void assertSorted(int[] test) {
        for ( int n=0; n<test.length-1; n++ ) {
            assertTrue(test[n] <= test[n+1]);
        }
    }
}