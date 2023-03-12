package com.nwshire.leetcode2019;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumTest {
    int test[] = new int[] {-1,0,1,2,-1,-4};

    @Test
    public void threeSum() {
        ThreeSum ts = new ThreeSum();

        ts.threeSum(test);
    }
}