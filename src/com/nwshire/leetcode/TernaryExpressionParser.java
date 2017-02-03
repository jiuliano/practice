package com.nwshire.leetcode;

/**
 * Created by james on 2/2/2017.
 */
public class TernaryExpressionParser {
    public String parseTernary(String expression) {
        String next = getNext(expression.substring(2), expression.startsWith("T?"));
        return next.length() == 1 ? next : parseTernary(next);
    }

    String getNext(String expression, boolean left) {
        String next = "X"; // invalid expression if X is returned.
        int level = 0;

        for ( int n=0; n<expression.length(); n++ ) {
            if ( expression.charAt(n) == ':' ) {
                if ( level == 0 ) {
                    next = left ? expression.substring(0, n) : expression.substring(n + 1);
                    break;
                }
                --level;
            } else if ( expression.charAt(n) == '?' ) {
                ++level;
            }
        }

        return next;
    }
}
