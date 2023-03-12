package com.nwshire.leetcode;

import java.util.StringTokenizer;

public class DefangIPAddr {
    public String defangIPaddr(String address) {

        StringBuilder result = new StringBuilder();
        StringTokenizer tok = new StringTokenizer(address, ".");

        while (tok.hasMoreTokens()) {
            result.append(tok.nextElement());
            if (tok.hasMoreTokens()) {
                result.append("[.]");
            }
        }

        return result.toString();
    }
}
