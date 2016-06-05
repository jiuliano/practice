package com.nwshire.leetcode;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String longest = "";

        if ( s.length() < 2 ) {
            longest = s;
        } else {
            char[] sArr = s.toCharArray();
            int mid = sArr.length/2;

            for ( int offset=0; offset<=mid; offset++ ) {
                int n = mid - offset;
                if ( n-1 >= 0 && n < sArr.length && sArr[n] == sArr[n-1] ) {
                    longest = walkPal(s, sArr, n-1, n, longest);
                }
                if ( n-1 >= 0 && n+1 < sArr.length && sArr[n-1] == sArr[n+1] ) {
                    longest = walkPal(s, sArr, n-1, n+1, longest);
                }

                n = mid + offset;
                if ( n-1 >= 0 && n < sArr.length && sArr[n] == sArr[n-1] ) {
                    longest = walkPal(s, sArr, n-1, n, longest);
                }
                if ( n-1 >= 0 && n+1 < sArr.length && sArr[n-1] == sArr[n+1] ) {
                    longest = walkPal(s, sArr, n-1, n+1, longest);
                }

                if ( longest.length() > ((mid - offset) * 2) ) {
                    break;
                }
            }
        }

        return longest;
    }

    String walkPal(String s, char[] sArr, int l, int r, String longest) {
        while ( l >= 0 && r < sArr.length && sArr[l] == sArr[r] ) {
            --l; ++r;
        }

        String next = s.substring(l+1,r);
        if ( longest.length() < next.length() ) {
            longest = next;
        }

        return longest;
    }
}
