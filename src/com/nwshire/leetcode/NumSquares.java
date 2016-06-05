package com.nwshire.leetcode;

/**
 * Created by james on 5/21/2016.
 */
public class NumSquares {
    public static void main(String args[]) {
        int result = numSquares(22345, true);
        System.out.println("Result: " + result + "\n");

        /*
        result = numSquares(83);
        System.out.println("Result: " + result + "\n");

        result = numSquares(125);
        System.out.println("Result: " + result + "\n");

        result = numSquares(23);
        System.out.println("Result: " + result + "\n");
        */
    }

    public static int numSquares(int n, boolean log) {
        int rt = (int)Math.sqrt(n);
        //System.out.print("Starting with rt " + rt + ": ");
        int count = countOut(n, rt--);
        if ( log ) {
            System.out.println("Try: " + count);
        }
        //System.out.println();
        int min = rt / 2;

        while ( rt > min ) {
            //System.out.print("Starting with rt " + rt + ": ");
            int nextCount = countOut(n, rt--);
            if ( log ) {
                System.out.println("Try: " + nextCount);
            }
            //System.out.println();
            if ( nextCount <= count ) {
                count = nextCount;
            }
        }

        return count;
    }

    private static int countOut(int n, int rt) {
        int count = 0;

        if ( rt > 1 ) {
            int value = rt * rt;
            int leftOver = n % value;
            count = (n / value);
            //for ( int x=0; x<count; x++ ) {
            //    System.out.print(value + " ");
            //}

            if ( leftOver > 0 ) {
                //rt = (int)Math.sqrt(leftOver);
                count = count + numSquares(leftOver, false);
            }
        } else {
            count = n;
            //for ( int x=0; x<count; x++ ) {
            //    System.out.print("1 ");
            //}
        }

        return count;
    }
}
