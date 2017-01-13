package com.nwshire.msh;

/**
 * Created by james on 1/12/2017.
 */
public class StoI {

    /**
     * Convert the string to integer value, assuming decimal notation, and possible leading sign.  Handle reasonable edge cases
     * such as null value, empty string, string with just a sign, and leading or trailing spaces gracefully.
     *
     * Two thoughts to make this more robust:
     * -- Add logic to recognize a decimal place
     * -- Add logic to recognize and flag incorrectly formatted values.  This implementation ignores any char values that are not digits (except of course, for a leading sign).
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
                    // Capture the sign.
                    sign = -1;
                } else if ( chars[i] >= '0' && chars[i] <= '9' ) {
                    intValue = (intValue * 10) + (chars[i] - '0');
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
