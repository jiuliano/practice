package com.nwshire.leetcode;

import java.util.Arrays;

/**
 * Created by james on 1/17/2017.
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if ( nums.length <= 3 ) {
            int sum = 0;
            for ( int n=0; n<nums.length; n++ ) {
                sum += nums[n];
            }
            return sum;
        }

        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        int min = Math.abs(sum - target);
        if ( min == 0 ) return sum;

        if ( min > 0 ) {
            for ( int i=0; i<nums.length-2; i++ ) {
                int j = i+1;
                int k = nums.length-1;

                while ( j < k ) {
                    int newSum = nums[i] + nums[j] + nums[k];
                    int newMin = Math.abs(newSum - target);

                    if ( newMin < min ) {
                        sum = newSum;
                        min = newMin;
                        if ( min == 0 ) return sum;
                    }

                    if ( newSum < target ) {
                        ++j;
                    } else {
                        --k;
                    }
                }
            }
        }

        return sum;
    }
}
