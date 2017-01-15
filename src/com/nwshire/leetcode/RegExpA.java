package com.nwshire.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 1/15/2017.
 */
public class RegExpA {
    public boolean isMatch(String s, String p) {
        PatternPart pps[] = loadPattern(p);
        return match(s, pps, 0);
    }

    private boolean match(String s, PatternPart pps[], int pi) {
        boolean match = false;

        if ( pi < pps.length ) {
            PatternPart p = pps[pi];

            if ( p.wildcard ) {
                if ( s.length() > 0 ) {
                    for ( int l=0; l<=s.length(); l++ ) {
                        match = l == 0 || p.charMatches(s.charAt(l-1));
                        if ( !match ) {
                            break; // wildcard exhausted
                        }

                        match = match(s.substring(l), pps, pi+1);
                        if ( match ) {
                            break; // match found
                        }
                    }
                } else {
                    match = match(s, pps, pi+1); // zero or more.
                }
            } else {
                if ( s.length() > 0 ) {
                    match = p.charMatches(s.charAt(0)) && match(s.substring(1), pps, pi+1);
                }
            }
        } else {
            match = s.length() == 0;
        }

        return match;
    }

    private PatternPart[] loadPattern(String p) {
        char pc[] = p.toCharArray();
        List<PatternPart> pps = new ArrayList<>();

        for ( int n=0; n < pc.length; ) {
            boolean wildcard = n+1 < pc.length && pc[n+1] == '*';

            pps.add(new PatternPart(pc[n], wildcard));
            n = n + ( wildcard ? 2 : 1 );
        }

        return pps.toArray(new PatternPart[0]);
    }

    private class PatternPart {
        char value;
        boolean wildcard;

        PatternPart(char value, boolean wildcard) {
            this.value = value;
            this.wildcard = wildcard;
        }

        public boolean charMatches(char c) {
            return value == '.' || value == c;
        }
    }
}
