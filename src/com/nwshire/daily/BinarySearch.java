package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class BinarySearch {
    public int binarySearch(int values[], int target) {
        int found = -1;
        int low = 0;
		int high = values.length-1;

		while ( low+1 < high ) {
			int mid = low + (high-low)/2;	
			if ( target <= values[mid] ) {
				high = mid;
			} else {
				low = mid;
			}
		}

		if ( target == values[low] ) {
		    found = low;
		} else if ( target == values[high] ) {
			found = high;
		}
		
        return found;
    }
}
