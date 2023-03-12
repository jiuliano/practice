package com.nwshire.coderbyte;

import java.util.Arrays;


public class MathChallenge {

    public static int mathChallenge(int num) {
        int highest = -1; // no negatives expected.
        char[] nc = Integer.toString(num).toCharArray();

        for (int n=0; n<nc.length-1; n++) {
            int value = toInteger(nc, n);
            if (highest < 0 || value > highest) {
                highest = value;
            }
        }

        return highest;
    }

    private static int toInteger(char[] nc, int i) {
        String sv = String.valueOf( Arrays.copyOfRange(nc, i, i+2) );
        return Integer.valueOf(sv);
    }
}
