package com.nwshire.leetcode;

/**
 * Created by james on 5/22/2016.
 */
public class NumMatrix {
    BinaryIndexedTree bit;
    int[][] matrix;

    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix nm = new NumMatrix(matrix);
        int value = nm.sumRegion(2,1,4,3);
        System.out.println("First value: " + value);
        nm.update(3,2,2);
        value = nm.sumRegion(2,1,4,3);
        System.out.println("Second value: " + value);
    }

    public NumMatrix(int[][] matrix) {
        RowColIdx rci = new RowColIdx(0, 0, matrix.length-1, matrix[0].length-1);
        bit = new BinaryIndexedTree(rci);
        this.matrix = matrix;

        for ( int r = 0; r<matrix.length; r++ ) {
            for ( int c=0; c<matrix[0].length; c++ ) {
                bit.add(r, c, matrix[r][c]);
            }
        }
    }

    public void update(int row, int col, int val) {
        int currentVal = matrix[row][col];
        bit.add(row, col, (val - currentVal));
        matrix[row][col] = val;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return bit.sum(row1, col1, row2, col2);
    }

    class RowColIdx {
        int startrow;
        int startcol;
        int rowlen;
        int rows;

        RowColIdx(int row1, int col1, int row2, int col2) {
            startrow = row1;
            startcol = col1;
            rowlen = (col2 - col1) + 1;
            rows = (row2 - row1) + 1;
        }

        int toIdx(int row, int col) {
            return rowlen * (row - startrow) + (col - startcol) + 1;
        }
    }

    class BinaryIndexedTree {
        protected int[] bit;
        RowColIdx rci;

        public BinaryIndexedTree(RowColIdx rci) {
            this.rci = rci;
            int size = rci.rows * rci.rowlen;
            bit = new int[size+1];
        }

        public int sum(int idx) {
            int sum = 0;

            while ( idx > 0 ) {
                sum = sum + bit[idx];
                idx = idx - (idx & -idx);
            }

            return sum;
        }

        public int sum(int row1, int col1, int row2, int col2) {
            int sum = 0;

            for ( int r = row1; r <= row2; r++ ) {
                sum = sum + sum(r, col1, col2);
            }

            return sum;
        }

        public int sum(int row, int from, int to) {
            int sum = sum(rci.toIdx(row,to));
            int lIdx = rci.toIdx(row,from) - 1;

            if ( lIdx > 0 ) {
                sum = sum - sum(lIdx);
            }

            return sum;
        }

        public void add(int row, int col, int value) {
            add(rci.toIdx(row,col), value);
        }

        public void add(int idx, int value) {
            while ( idx < bit.length ) {
                bit[idx] += value;
                idx = idx + (idx & -idx);
            }
        }
    }
}