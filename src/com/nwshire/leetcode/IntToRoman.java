package com.nwshire.leetcode;

/**
 * Created by james on 1/15/2017.
 */
public class IntToRoman {
    private String symbols[] = new String[] {
            "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"
    };

    private int values[] = new int[] {
            1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000
    };

    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        int place = values.length-1;

        while ( num > 0 && place >= 0 ) {
            int div = num / values[place];

            if ( div > 0 ) {
                if ( symbols[place].length() == 1 && div <= 3 ) {
                    for ( int n=0; n<div; n++ ) {
                        roman.append(symbols[place]);
                    }

                    num = num - (values[place] * div);
                } else if ( div == 1 ) {
                    roman.append(symbols[place]);
                    num = num - values[place];
                }
            }

            --place;
        }

        return roman.toString();
    }
}
