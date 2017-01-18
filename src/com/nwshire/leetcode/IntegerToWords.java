package com.nwshire.leetcode;

/**
 * Created by james on 1/17/2017.
 */
public class IntegerToWords {
    private String groupName[] = new String[] {
            " Billion", " Million", " Thousand", ""
    };

    private String singles[] = new String[] {
            "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };

    private String tensNames[] = new String[] {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private String teensNames[] = new String[] {
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    public String numberToWords(int num) {
        if ( num == 0 )
            return "Zero";

        // 2,147,483,647
        int groups[] = new int[4];

        for ( int i=0; i<groups.length; i++ ) {
            if ( i == 0 )
                groups[3-i] = num;
            else
                groups[3-i] = groups[3-i+1]/1000;
        }

        StringBuilder wordNumber = new StringBuilder();

        int temp = groups[0];
        wordNumber.append(getGroupWord(groups[0], 0));

        for ( int i=1; i<groups.length; i++ ) {
            groups[i] = groups[i] - (temp * 1000);
            temp = temp * 1000 + groups[i];
            String groupWord = getGroupWord(groups[i], i);
            if ( groupWord.length() > 0 ) {
                wordNumber.append(" ").append(groupWord);
            }
        }

        return wordNumber.toString().trim();
    }

    private String getGroupWord(int group, int pos) {
        StringBuilder groupWord = new StringBuilder();
        String space = "";

        int hundreds = group / 100;
        if ( hundreds > 0 ) {
            groupWord.append(space).append(singles[hundreds]).append(" Hundred");
            group = group - (hundreds * 100);
            space = " ";
        }

        if ( group > 19 ) {
            int tens = group / 10;
            groupWord.append(space).append(tensNames[tens]);

            int ones = group-(tens * 10);
            if ( ones > 0 ) {
                groupWord.append(" ").append(singles[ones]);
            }
        } else if ( group > 9 ) {
            groupWord.append(space).append(teensNames[group-10]);
        } else if ( group > 0 ) {
            groupWord.append(space).append(singles[group]);
        }

        if ( groupWord.length() > 0 ) {
            groupWord.append(groupName[pos]);
        }

        return groupWord.toString();
    }
}
