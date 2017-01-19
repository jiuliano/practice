package com.nwshire.leetcode;

import org.junit.Test;

/**
 * Created by james on 1/18/2017.
 */
public class BitwiseOpsTest {
    @Test
    public void hammingWeight() throws Exception {
        BitwiseOps hw = new BitwiseOps();
        int hwValue = hw.hammingWeight(Integer.MIN_VALUE);
        System.out.println(hwValue);

        int rValue = hw.reverseBits(1);
        System.out.println(Integer.toBinaryString(rValue));
        System.out.println(Integer.toBinaryString(1));
    }
}