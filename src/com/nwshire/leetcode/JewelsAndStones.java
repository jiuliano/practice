package com.nwshire.leetcode;

import java.util.Arrays;

public class JewelsAndStones {
    private static final int LC_A = Character.getNumericValue('a');
    private static final int UC_A = Character.getNumericValue('A');

    public int numJewelsInStones(String J, String S) {
        boolean jewels[] = new boolean[52];
        char JArr[] = J.toCharArray();
        char SArr[] = S.toCharArray();
        int count = 0;

        Arrays.fill(jewels, false);
        for (int n=0; n<JArr.length; n++) {
            jewels[getIdx(JArr[n])] = true;
        }

        for (int n=0; n<SArr.length; n++) {
            if (jewels[getIdx(SArr[n])]) {
                ++count;
            }
        }

        return count;
    }

    private int getIdx(char letter) {
        int lv = Character.getNumericValue(letter);


        if (Character.isLowerCase(letter)) {
            return(lv - LC_A);
        }

        return (26 + (lv - UC_A));
    }
}
