package com.nwshire;

/**
 * Created by james on 1/18/2017.
 */
public class FindLowest {
    // 1, 2, 3, 4, 5, 6, 7
    // 4, 5, 6, 7, 1, 2, 3
    // 2, 3, 4, 5, 6, 7, 1
    // 7, 1, 2, 3, 4, 5, 6
    public int findLowest(int arr[]) {
        int minIndex = -1;

        if ( arr.length > 0 ) {
            minIndex = 0;
            int low = 0;
            int high = arr.length-1;

            while ( low+1 < high ) {
                int mid = low + ((high - low) / 2);
                if ( arr[low] > arr[mid] ) {
                    high = mid;
                } else if ( arr[mid] > arr[high] ) {
                    low = mid;
                } else {
                    break; // list is not roated.  exit.
                }
            }

            minIndex = arr[low] < arr[high] ? low : high;
        }

        return minIndex;
    }

    public int findLowestLive(int arr[]) {
        int minIndex = -1;

        if ( arr.length > 0 ) {
            minIndex = 0;
            int i = arr.length / 2;

            int low = 0;
            int high = arr.length-1;

            int in = findNext(arr, low, i, high);
            while ( in != -1 && Math.abs(in - i) > 1 ) {
                if ( in > i ) {
                    low = i;
                } else {
                    high = i;
                }

                i = in;
                in = findNext(arr, low, i, high);
            }

            if ( in == -1 ) {
                minIndex = 0;
            } else if ( arr[i] > arr[in] ) {
                minIndex = in;
            } else {
                minIndex = i;
            }
        }

        return minIndex;
    }

    private int findNext(int arr[], int low, int i, int high) {
        if ( arr[low] > arr[i] ) {
            i = low + ((i-low)/2);
        } else if ( arr[high] < arr[i] ) {
            i = high - ((high - i)/2);
        } else {
            i = -1; // list is not rotated
        }

        return i;
    }

    public int findLowestON(int arr[]) {
        int minIndex = -1;

        if ( arr.length > 0 ) {
            minIndex = 0;
            int i = 1;

            while ( i < arr.length ) {
                if ( arr[i] < arr[minIndex] ) {
                    minIndex = i;
                }

                if ( arr[i] < arr[i-1] ) {
                    minIndex = i;
                    break;
                }
            }
        }

        return minIndex;
    }
}
