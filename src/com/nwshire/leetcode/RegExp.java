package com.nwshire.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 5/31/2016.
 */
public class RegExp {
    public static void main(String[] args) {
        RegExp re = new RegExp();
        boolean is;
        /*
        is = re.isMatch("aa","a"); // false
        System.out.println("is: " + is);
        is = re.isMatch("aa","aa"); // true
        System.out.println("is: " + is);
        is = re.isMatch("aaa","aa"); // false
        System.out.println("is: " + is);
        is = re.isMatch("aa", "a*"); // true
        System.out.println("is: " + is);
        is = re.isMatch("aa", ".*"); // true
        System.out.println("is: " + is);
        is = re.isMatch("ab", ".*"); // true
        System.out.println("is: " + is);
        is = re.isMatch("aab", "c*a*b"); // true
        System.out.println("is: " + is);
        is = re.isMatch("aaa", "ab*ac*a"); // true
        System.out.println("is: " + is);
        */
        is = re.isMatch("a", "ab*"); // true
        System.out.println("is: " + is);
    }

    public boolean isMatch(String s, String p) {
        Part[] parts = loadPattern(p);
        char[] sArr = s.toCharArray();

        return match(sArr, 0, parts, 0);
    }

    boolean match(char[] sArr, int start, Part[] parts, int partNo) {
        boolean matches = false;

        if ( start < sArr.length && partNo < parts.length ) {
            Part part = parts[partNo];

            int upto = part.matchesTo(sArr, start);
            if ( !part.wildcard ) {
                if ( upto > start ) {
                    matches = match(sArr, upto, parts, partNo+1);
                } else {
                    matches = false;
                }
            } else if ( upto > start ) {
                for ( int n = upto; n>=start && !matches; n-- ) {
                    matches = match(sArr, n, parts, partNo+1);
                }
            } else if ( upto == start ) {
                matches = match(sArr, upto, parts, partNo+1);
            }
        } else {
            if ( start == sArr.length ) {
                while ( partNo < parts.length ) {
                    Part part = parts[partNo];
                    if ( part.wildcard ) {
                        ++partNo;
                    } else {
                        break;
                    }
                }
                matches = partNo == parts.length;
            }
        }

        //System.out.println("Return with start: " + start + ", partNo: " + partNo + ", returned: " + matches);
        return matches;
    }

    Part[] loadPattern(String p) {
        char[] pArr = p.toCharArray();
        List<Part> parts = new ArrayList<Part>();

        for ( int n=0; n<pArr.length; n++ ) {
            boolean wildcard = ( n+1 < pArr.length && pArr[n+1] == '*' );

            if ( pArr[n] == '.' ) {
                parts.add(new Part(wildcard));
            } else {
                parts.add(new Part(pArr[n], wildcard));
            }

            if ( wildcard ) {
                ++n;
            }
        }

        //System.out.println("loadParts loaded " + parts.size() + " parts");
        return parts.toArray(new Part[0]);
    }

    class Part {
        Character match;
        boolean wildcard;

        Part(char match, boolean wildcard) {
            this.match = match;
            this.wildcard = wildcard;
        }

        Part(boolean wildcard) {
            this.match = null;
            this.wildcard = wildcard;
        }

        int matchesTo(char[] value, int start) {
            int to = -1;

            if ( value.length - start > 0 ) {
                if ( !wildcard ) {
                    if ( match == null || match == value[start] ) {
                        to = start + 1;
                    }
                } else {
                    if (match == null) {
                        to = value.length;
                    } else if (match == value[start]) {
                        to = start + 1;
                        while (to < value.length && match == value[to]) {
                            ++to;
                        }
                    } else {
                        to = start;
                    }
                }
            }

            /*
            System.out.print("Part char: " + match + "; wildcard: " + wildcard + "; matches: >");
            while ( start < to ) {
                System.out.print(value[start++]);
            }
            System.out.println("<");
            */

            return to;
        }
    }
}
