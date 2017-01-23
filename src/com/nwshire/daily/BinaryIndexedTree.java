package com.nwshire.daily;

/**
 * Created by james on 1/20/2017.
 */
public class BinaryIndexedTree {
	int[] bit;

    public BinaryIndexedTree(int size) {
        bit = new int[size+1];
	}

    public int sum(int idx) {
		int value = 0;
		while ( idx > 0 ) {
			value += bit[idx];
			idx = idx - (idx & -idx);
		}

		return value;
    }

    public void add(int idx, int value) {
		while ( idx < bit.length ) {
			bit[idx] += value;
			idx = idx + (idx & -idx);
		}
    }
}
