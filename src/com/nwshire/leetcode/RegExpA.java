package com.nwshire.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 1/15/2017.
 */
public class RegExpA {
    public boolean isMatch(String s, String p) {
        return match(s, p);
    }

    private boolean match(String s, String p) {
        boolean match = false;

        if ( p.length() > 0 ) {
            char value = p.charAt(0);
            boolean wildcard = p.length() > 1 && p.charAt(1) == '*';

            if ( wildcard ) {
                if ( s.length() > 0 ) {
                    for ( int l=0; l<=s.length(); l++ ) {
                        match = l == 0 || (value == '.' || value == s.charAt(l-1));
                        if ( !match ) {
                            break; // wildcard exhausted
                        }

                        match = match(s.substring(l), p.substring(2));
                        if ( match ) {
                            break; // match found
                        }
                    }
                } else {
                    match = match(s, p.substring(2)); // zero or more.
                }
            } else {
                if ( s.length() > 0 ) {
                    match = (value == '.' || value == s.charAt(0)) && match(s.substring(1), p.substring(1));
                }
            }
        } else {
            match = s.length() == 0;
        }

        return match;
    }
}