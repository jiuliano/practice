package com.nwshire.leetcode;

/**
 * Created by james on 6/1/2016.
 */
public class GoogleScreen {
    public static void main(String[] args) {
        Rect r1 = new Rect(0,0, 2,2);
        Rect r2 = new Rect(3,3, 5,5);

        boolean result = areOverlapping(r1,r2); // assert false
        System.out.println("assert false: " + result);

        r1 = new Rect(0,0, 2,2);
        r2 = new Rect(0,3, 3,5);

        result = areOverlapping(r1,r2); // assert false
        System.out.println("assert false: " + result);

        r1 = new Rect(0,0, 2,2);
        r2 = new Rect(1,1, 4,4);

        result = areOverlapping(r1,r2); // assert true
        System.out.println("assert true: " + result);
    }

    static boolean areOverlapping(Rect r1, Rect r2) {
        return !( noXOverlap(r1,r2) || noYOverlap(r1,r2) );
    }

    static boolean noXOverlap(Rect r1, Rect r2) {
        return noRangeOverlap(r1.x1, r1.x2, r2.x1, r2.x2);
    }

    static boolean noYOverlap(Rect r1, Rect r2) {
        return noRangeOverlap(r1.y1, r1.y2, r2.y1, r2.y2);
    }

    static boolean noRangeOverlap(int n1, int n2, int m1, int m2) {
        int min = Math.min(m1,m2);
        int max = Math.max(m1,m2);

        return (n1 < min && n2 < min) || (n1 > max && n2 > max);
    }

    static class Rect {
        int x1,y1;
        int x2,y2;

        Rect(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
}
