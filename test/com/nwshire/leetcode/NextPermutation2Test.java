package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextPermutation2Test {
    @Test
    public void nextPermutation() {
        int[] nums;
        NextPermutation2 np = new NextPermutation2();

        nums = new int[] { 1, 5, 1 };
        np.nextPermutation(nums);
        assertArrayEquals(nums, new int[] { 5, 1, 1 });

        nums = new int[] { 1, 3, 2 };
        np.nextPermutation(nums);
        assertArrayEquals(nums, new int[] { 2, 1, 3 });

        nums = new int[] { 1, 2 };
        np.nextPermutation(nums);
        assertArrayEquals(nums, new int[] { 2, 1 });

        nums = new int[] { 1, 2, 3 };
        np.nextPermutation(nums);
        assertArrayEquals(nums, new int[] { 1, 3, 2 });

        nums = new int[] { 2, 3, 1 };
        np.nextPermutation(nums);
        assertArrayEquals(nums, new int[] { 3, 1, 2 });

        nums = new int[] { 3, 2, 1 };
        np.nextPermutation(nums);
        assertArrayEquals(nums, new int[] { 1, 2, 3 });

        nums = new int[] { 1, 1, 5 };
        np.nextPermutation(nums);
        assertArrayEquals(nums, new int[] { 1, 5, 1 });
    }
}
