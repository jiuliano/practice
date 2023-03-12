package com.nwshire.leetcode;

public class NextPermutation2 {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;

        int lt = findLt(nums);
        if (lt < 0) {
            reverse(nums, 0);
        } else {
            int sw = findSw(nums, lt);
            swap(nums, lt, sw);
            reverse(nums, lt + 1);
        }
    }

    private int findLt(int[] nums) {
        for (int n=nums.length-1; n>0; n--) {
            if (nums[n] > nums[n-1]) {
                return n-1;
            }
        }

        return -1;
    }

    private int findSw(int[] nums, int lt) {
        for (int n=lt+1; n<nums.length; n++) {
            if (nums[n] <= nums[lt]) {
                return n-1;
            }
        }

        return nums.length-1;
    }

    private void reverse(int[] nums, int s) {
        int e = nums.length-1;
        while (s < e) {
            swap(nums, s++, e--);
        }
    }

    private void swap(int nums[], int f, int t) {
        int temp = nums[f];
        nums[f] = nums[t];
        nums[t] = temp;
    }
}
