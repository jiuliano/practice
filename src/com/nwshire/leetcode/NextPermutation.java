package com.nwshire.leetcode;

import java.util.*;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;

        int found = findPos(nums);
        List<Integer> digits = getDigits(nums, nums.length-found);

        if (found > 0) {
            int old = nums[found-1];
            nums[found-1] = swapNext(old, digits);
        }

        for (int digit : digits) {
            nums[found++] = digit;
        }
    }


    private int findPos(int[] nums) {
        int found = 0;

        for (int n=nums.length-1; n>0; n--) {
            if (nums[n] > nums[n-1]) {
                found = n;
                break;
            }
        }

        return found;
    }


    private int swapNext(int last, List<Integer> digits) {
        Integer found = 0;

        for (int digit : digits) {
            if (digit > last) {
                found = digit;
                break;
            }
        }

        digits.remove(found);
        digits.add(last);
        digits.sort(Comparator.naturalOrder());
        return found;
    }


    private List<Integer> getDigits(int[] nums, int len) {
        List<Integer> digits = new ArrayList<>();
        int start = nums.length - len;

        for (int n=start; n<nums.length; n++) {
            digits.add(nums[n]);
        }

        digits.sort(Comparator.naturalOrder());
        return digits;
    }
}
