package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/17/2017.
 */
public class ThreeSumClosestTest {
    @Test
    public void threeSumClosest() throws Exception {
        ThreeSumClosest tsc = new ThreeSumClosest();
        int nums[] = new int[] { -1, 2, 1, -4 };
        assertEquals(tsc.threeSumClosest(nums, 1), 2);
    }
}