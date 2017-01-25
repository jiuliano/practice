package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class BinarySearch {
    public int binarySearch(int values[], int target) {
        int found = -1;
		int from = 0;
		int to = values.length-1;
		
		while ( to - from > 1 ) {
			int mid = from + (to-from)/2;
			
			if ( values[from] <= target && target <= values[mid] ) {
				to = mid;
			} else if ( values[mid] <= target && target <= values[to] ) {
				from = mid;
			} else {
				break; // not found;
			}
		}
		
		if ( values[from] == target ) {
			found = from;
		} else if ( values[to] == target ) {
			found = to;
		}

        return found;
    }
}
