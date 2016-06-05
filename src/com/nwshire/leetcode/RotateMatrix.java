package com.nwshire.leetcode;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        Matrix mObj = new Matrix(matrix);
        int c = mObj.max / 2;

        while ( c >= 0 ) {
            rotateN(mObj, c--);
        }
    }

    void rotateN(Matrix mObj, int c) {
        int cx = mObj.max - c;

        for ( int n=c; n<cx; n++ ) {
            int temp = mObj.set(cx,n, mObj.get(n,c));
            temp = mObj.set(mObj.max-n,cx, temp);
            temp = mObj.set(c,mObj.max-n, temp);
            mObj.set(n,c, temp);
        }
    }

    class Matrix {
        int[][] matrix;
        int max;

        Matrix(int[][] matrix) {
            this.matrix = matrix;
            this.max = matrix.length-1;
        }

        int get(int x, int y) {
            return matrix[y][x];
        }

        int set(int x, int y, int value) {
            int oldValue = matrix[y][x];
            matrix[y][x] = value;
            return oldValue;
        }
    }
}
