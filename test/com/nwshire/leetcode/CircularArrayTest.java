package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/31/2017.
 */
public class CircularArrayTest {
    @Test
    public void circularArrayLoop() throws Exception {
        CircularArray ca = new CircularArray();

        assertFalse(ca.circularArrayLoop(new int[] { -2, 1, -1, -2, -2 }));
        assertFalse(ca.circularArrayLoop(new int[] { -1, -2, -3, -4, -5 }));
        assertTrue(ca.circularArrayLoop(new int[] { 2, -1, 1, 2, 2 }));
        assertFalse(ca.circularArrayLoop(new int[] { 2, 2 }));
    }

}