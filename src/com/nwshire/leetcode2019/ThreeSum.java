package com.nwshire.leetcode2019;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for ( int a=0; a < nums.length-2; a++ ) {
            if ( a == 0 || nums[a] != nums[a-1] ) {
                for ( int b=(a+1); b < nums.length-1; b++ ) {
                    if ( b == (a+1) || nums[b] != nums[b-1] ) {
                        for ( int c=(b+1); c < nums.length; c++ ) {
                            if ( c == (b+1) || nums[c] != nums[c-1] ) {
                                if ( (nums[a] + nums[b] + nums[c]) == 0 ) {
                                    result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }

}
