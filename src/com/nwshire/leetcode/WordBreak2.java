package com.nwshire.leetcode;

import java.util.Set;

public class WordBreak2 {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] foundUpto = new boolean[s.length()+1];
        int maxWordLength = longestWord(wordDict);

        foundUpto[0] = true;

        for ( int l=1; l<=s.length(); l++ ) {
            int from = Math.max(1, l - maxWordLength);

            for ( int n=from; n<=l; n++ ) {
                if ( foundUpto[n-1] && wordDict.contains(s.substring((n-1), l)) ) {
                    foundUpto[l] = true;
                    break;
                }
            }
        }

        return foundUpto[s.length()];
    }

    public int longestWord(Set<String> wordDict) {
        int max = 0;

        for ( String word : wordDict ) {
            int length = word.length();
            if ( length > max ) {
                max = length;
            }
        }

        return max;
    }
}
