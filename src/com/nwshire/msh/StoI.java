package com.nwshire.msh;

/**
 * Created by james on 1/12/2017.
 */
public class StoI {

    /**
     * Convert the string to integer value, assuming decimal notation, and possible leading sign.  Handle reasonable edge cases
     * such as null value, empty string, string with just a sign, and leading or trailing spaces gracefully.
     *
     * Invalid
     *
     * @param stringValue
     * @return
     */
    public static int stringToInteger(String stringValue) {
        int intValue = 0;
        int sign = 1; // default to "positive"

        if ( stringValue != null ) {
            char chars[] = stringValue.trim().toCharArray();

            for ( int i=0; i<chars.length; i++ ) {
                if ( i == 0 && chars[i] == '-' ) {
                    sign = -1;
                } else if ( i == 0 && chars[i] == '+' ) {
                    sign = 1;
                } else if ( chars[i] >= '0' && chars[i] <= '9' ) {
                    intValue = (intValue * 10) + (chars[i] - '0');
                } else {
                    intValue = 0; // invalid input
                    break;
                }
            }
        }

        // Multiply by sign, to set positive or negative.
        return intValue * sign;
    }

    public static void main(String argv[]) {
        // Tests
        System.out.println(stringToInteger(null));
        System.out.println(stringToInteger(""));
        System.out.println(stringToInteger("-"));
        System.out.println(stringToInteger("-100"));
        System.out.println(stringToInteger("-000123"));
        System.out.println(stringToInteger("+333"));
        System.out.println(stringToInteger("  345 "));
        System.out.println(stringToInteger("100,000"));
    }
}
