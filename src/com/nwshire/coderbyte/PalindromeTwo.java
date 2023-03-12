package com.nwshire.coderbyte;


public class PalindromeTwo {

    public static String PalindromeTwo(String str) {
        char[] sc = str.toCharArray();
        int l = 0;
        int r = sc.length-1;

        while (l < r) {
            while (!Character.isAlphabetic(sc[l]) && l < r) l++;
            while (!Character.isAlphabetic(sc[r]) && r > l) r--;

            if (Character.toLowerCase(sc[l]) != Character.toLowerCase(sc[r]))
                return "false";

            l++;
            r--;
        }

        return "true";
    }
}
