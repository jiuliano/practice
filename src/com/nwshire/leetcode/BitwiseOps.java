package com.nwshire.leetcode;

/**
 * Created by james on 1/18/2017.
 */
public class BitwiseOps {
    static final int bits[] = new int[] {
            0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2,  3,  2,  3,  3,  4
    };

    static final int rbits[] = new int[] {
            0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15
    };

    public int hammingWeight(int n) {
        int weight = 0;

        while ( n != 0 ) {
            weight += bits[n & 0x0f];
            n >>>= 4;
        }

        return weight;
    }

    public int reverseBits(int n) {
        int rn = 0;

        for ( int i=0; i<8; i++ ) {
            rn = rn << 4 | rbits[n & 0x0f];
            n >>>= 4;
        }

        return rn;
    }
}
