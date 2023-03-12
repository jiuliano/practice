package com.nwshire;

/**
 * Created by james on 5/22/2016.
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
