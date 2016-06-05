package com.nwshire;

/**
 * Created by james on 5/27/2016.
 */
public class OraSum {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, -1, 2, 3, -2, 5, 2, -3, 1 };
        OraSum os = new OraSum();

        int max = os.getMaxSum(arr);
        System.out.println("Max: " + max);
    }

    int getMaxSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        if ( arr != null && arr.length > 1 ) {
            for ( int n=0; n<arr.length; n++ ) {
                sum += arr[n];
                if ( sum > max ) {
                    max = sum;
                }
            }

            for ( int n=0; n<arr.length; n++ ) {
                sum = sum - arr[n];
                if ( sum > max ) {
                    max = sum;
                }

                int nSum = sum;
                for ( int m = arr.length-1; m>n; m-- ) {
                    nSum = nSum - arr[m];
                    if ( nSum > max ) {
                        max = nSum;
                    }
                }
            }
        } else if ( arr.length == 1 ){
            max = arr[0];
        }

        return max;
    }

    int getMaxSum(int[] arr, int end) {
        int start = 0;
        int sum = 0;

        for ( int n=start; n<end; n++ ) {
            sum += arr[n];
        }

        int maxSum = sum;
        while ( end < arr.length ) {
            sum = sum + arr[end++] - arr[start++];
            if ( sum > maxSum ) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
