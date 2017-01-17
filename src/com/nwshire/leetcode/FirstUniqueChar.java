package com.nwshire.leetcode;

/**
 * Created by james on 1/17/2017.
 */
public class FirstUniqueChar {
    public int firstUniqChar(String s) {
        char word[] = s.toCharArray();
        int ccount[] = new int[256];
        int uniq = -1;

        for ( int i=0; i<word.length; i++ ) {
            ++ccount[word[i]];

            if ( uniq == -1 ) {
                if ( ccount[word[i]] == 1 ) {
                    uniq = i;
                }
            } else if ( ccount[word[uniq]] > 1 ) {
                while ( uniq <= i && ccount[word[uniq]] > 1 ) {
                    ++uniq;
                }

                if ( uniq >= word.length || ccount[word[uniq]] > 1 ) {
                    uniq = -1;
                }
            }
        }

        return uniq;
    }
}
