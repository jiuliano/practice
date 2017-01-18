package com.nwshire.leetcode;

/**
 * Created by james on 1/17/2017.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";

        if ( strs.length > 0 ) {
            prefix = strs[0];

            for ( int n=1; n<strs.length; n++ ) {
                int mdx = 0;
                while ( mdx < strs[n].length() && mdx < prefix.length() && strs[n].charAt(mdx) == prefix.charAt(mdx) ) {
                    ++mdx;
                }

                prefix = prefix.substring(0, mdx);
            }
        }

        return prefix;
    }
}
