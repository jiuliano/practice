package com.nwshire.daily;

/**
 * Created by james on 1/20/2017.
 */
public class BinaryIndexedTree {
    protected int[] bit;

    public BinaryIndexedTree(int size) {
        bit = new int[size];
    }

    public int sum(int idx) {
        int sum = 0;

        while ( idx > 0 ) {
            sum = sum + bit[idx];
            idx = idx - (idx & -idx);
        }

        return sum;
    }

    public void add(int idx, int value) {
        while ( idx < bit.length ) {
            bit[idx] += value;
            idx = idx + (idx & -idx);
        }
    }
}
