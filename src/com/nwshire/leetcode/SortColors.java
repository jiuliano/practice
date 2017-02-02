package com.nwshire.leetcode;

/**
 * Created by james on 2/2/2017.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if ( nums.length <= 2 ) { // <=2-element edge case, swap if out of order and/or return.
            if ( nums.length == 2 && nums[0] > nums[1] ) {
                swap(nums, 0, 1);
            }

            return;
        }

        int low = 0;
        int high = nums.length-1;
        int mid = low;

        while ( low < high && low <= mid && mid <= high ) {
            while ( low < high && nums[low] == 0 ) ++low; // increment to the next low swap pos
            while ( low < high && nums[high] == 2 ) --high;  // decrement to the next high swap pos

            if ( mid < low ) {
                mid = low; // reset mid if it is out of range
            }

            if ( nums[low] == 2 && nums[high] == 0 ) { // just swap straight across
                swap(nums, low, high);
            } else if ( mid < nums.length && nums[mid] == 0 ) {  // if 0, swap to the left
                swap(nums, low, mid);
            } else if ( mid < nums.length && nums[mid] == 2 ) { // if 2, swap to the right
                swap(nums, mid, high);
            } else { // if 1, increment mid for next pass
                ++mid;
            }
        }
    }

    void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}
