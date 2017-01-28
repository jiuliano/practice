package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class BinarySearch {
    public int binarySearch(int values[], int target) {
        int found = -1;
		int fr = 0;
		int to = values.length-1;
		
		while ( to - fr > 1 ) {
			int mid = fr + (to-fr)/2;
			
			if ( values[fr] <= target && target <= values[mid] ) {
				to = mid;
			} else if ( values[mid] <= target && target <= values[to] ) {
				fr = mid;
			} else {
				break;
			}
		}
		
		if ( values[fr] == target ) {
			found = fr;
		} else if ( values[to] == target ) {
			found = to;
		}

        return found;
    }
}
