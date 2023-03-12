package com.nwshire.coderbyte;


import java.util.Arrays;

class Needler {
    int[] needle = new int[26];
    int[] found = new int[26];

    public Needler(String s) {
        Arrays.fill(needle, 0);
        Arrays.fill(found, 0);
        char[] sc = s.toCharArray();

        for (int n=0; n<sc.length; n++) {
            needle[idx(sc[n])]++;
        }
    }

    private int idx(char c) {
        return c - 'a';
    }

    boolean add(char c) {
        int i = idx(c);
        found[i]++;
        return isMatch();
    }

    boolean remove(char c) {
        int i = idx(c);
        found[i]--;
        return isMatch();
    }

    boolean isMatch() {
        for (int n=0; n<needle.length; n++) {
            if (found[n] < needle[n]) {
                return false;
            }
        }

        return true;
    }
}

public class MinWindowSubstring {
    public static String minWindowSubstring(String hs, String n) {
        char[] hsc = hs.toCharArray();
        Needler nd = new Needler(n);
        int bi = 0;
        int ei = 0;

        String result = "";
        while (true) {
            while (ei < hsc.length && !nd.add(hsc[ei++]));

            if (nd.isMatch()) {
                while (bi <= ei && nd.remove(hsc[bi++]));
                String nr = hs.substring(bi-1, ei);
                if (result.length() == 0 || nr.length() < result.length()) {
                    result = nr;
                }
            } else {
                break;
            }
        }

        return result;
    }
}
