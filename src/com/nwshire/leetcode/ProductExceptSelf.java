package com.nwshire.leetcode;

/**
 * Created by james on 1/17/2017.
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int prods[] = new int[nums.length];

        // stack up the products from right to left
        int last = 1;
        for ( int n=nums.length-1; n>0; n-- ) {
            prods[n] = last = (last * nums[n]);
        }

        // produce results from left to right, using stacked values from previous loop, * accumulated ltor product
        last = 1;
        for ( int n=0; n<nums.length; n++ ) {
            prods[n] = last * (n+1 < nums.length ? prods[n+1] : 1);
            last = last * nums[n];
        }

        return prods;
    }
}
