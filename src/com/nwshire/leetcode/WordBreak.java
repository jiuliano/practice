package com.nwshire.leetcode;

import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int maxWord = getMax(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];

        // len: 12
        // i: 1 to 12
        // i: 1
        // j: 1 to 1
        // i: 12
        // j: 6 to 12
        dp[0] = true;
        for (int i = 1; i <= len; i ++) {
            int start = Math.max(1, i - maxWord);
            for (int j = start; j <= i; j++) {
                if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
                    System.out.println("Found word: " + s.substring(j - 1, i) + ", setting dp[" + i + "] to true");
                    dp[i] = true;
                    break;
                } else if ( !dp[j - 1] ) {
                    System.out.println("dp[" + (j-1) + "] is false");
                } else {
                    System.out.println("Did not find: " + s.substring(j - 1, i) + ", checked because dp[" + (j-1) + "] is true");
                }
            }
        }

        return dp[len];
    }

    private int getMax(Set<String> wordDict) {
        int max = 0;
        for (String str : wordDict) {
            max = Math.max(max, str.length());
        }
        return max;
    }
}
