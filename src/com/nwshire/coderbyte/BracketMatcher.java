package com.nwshire.coderbyte;


public class BracketMatcher {

    public static String BracketMatcher(String str) {
        int count = 0;
        char[] strc = str.toCharArray();

        for (char c : strc) {
            if ( c == '(' ) {
                count += 1;
            } else if ( c == ')' ) {
                if (count <= 0) {
                    return "0";
                } else {
                    count -= 1;
                }
            }
        }

        return count == 0 ? "1" : "0";
    }
}
