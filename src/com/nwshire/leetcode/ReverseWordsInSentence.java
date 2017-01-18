package com.nwshire.leetcode;

/**
 * Created by james on 1/18/2017.
 */
public class ReverseWordsInSentence {
    // In-place...
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length-1);

        int b = 0;
        while ( b < s.length ) {
            int e = findeow(s, b);
            reverse(s, b, e);
            b = e + 2;
        }
    }

    // return the index to the last char of the next word.
    private int findeow(char[] s, int i) {
        while ( i < s.length && s[i] != ' ' )
            ++i;

        return i-1;
    }

    // reverse from b to e inclusive
    private void reverse(char[] s, int b, int e) {
        while ( b < e ) {
            char c = s[b];
            s[b] = s[e];
            s[e] = c;
            --e; ++b;
        }
    }
}
