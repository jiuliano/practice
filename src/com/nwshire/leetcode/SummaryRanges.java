package com.nwshire.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        int[] nums = new int[] { -2147483648, -2147483647, 2147483647 };
        List<String> ranges = summaryRanges(nums);
        String comma = "";

        System.out.print("{ ");
        for ( String range : ranges ) {
            System.out.print(comma + range);
            comma = ", ";
        }

        System.out.println(" }");
    }

    private static boolean isOneApart(int n1, int n2) {
        boolean is = false;

        if ( n1 == Integer.MIN_VALUE ) {
            is = (n1+1) == n2;
        } else if ( n2 == Integer.MAX_VALUE ) {
            is = n1 == (n2-1);
        } else {
            is = (n2-n1) == 1;
        }

        return is;
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<String>();

        if ( nums.length >= 1 ){
            String range = "";

            // [0,1,2,4,5,7]
            for ( int n=1; n<nums.length; n++ ) {
                if ( !isOneApart(nums[n-1], nums[n]) ) {
                    if ( range.length() == 0 ) {
                        ranges.add(String.valueOf(nums[n-1]));
                    } else {
                        ranges.add(range + nums[n-1]);
                        range = "";
                    }
                } else if ( range.length() == 0 ) {
                    range = nums[n-1] + "->";
                }
            }

            if ( range.length() == 0 ) {
                ranges.add(String.valueOf(nums[nums.length-1]));
            } else {
                ranges.add(range + nums[nums.length-1]);
            }
        }

        return ranges;
    }
}
