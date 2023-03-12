package com.nwshire.leetcode;

public class RemoveVowels {
    public String removeVowels(String S) {
        char c[] = S.toCharArray();
        StringBuilder result = new StringBuilder();

        for (int n=0; n<c.length; n++) {
            switch (c[n]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    break;
                default:
                    result.append(c[n]);
                    break;
            }
        }

        return result.toString();
    }
}
