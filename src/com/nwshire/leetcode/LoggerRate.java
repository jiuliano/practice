package com.nwshire.leetcode;

import java.util.HashSet;
import java.util.Set;

import static java.lang.System.out;

/**
 * Created by james on 1/10/2017.
 */
public class LoggerRate {
    //private Map<String,Integer> lm = new HashMap<String,Integer>();
    private Set<String> msgs[];
    private int lt = -1;


    /** Initialize your data structure here. */
    public LoggerRate() {
        msgs = new Set[10];
        for ( int n=0; n<msgs.length; n++ ) {
            msgs[n] = new HashSet<String>();
        }
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int x = timestamp % msgs.length;

        if ( lt > -1 && timestamp != lt ) {
            for ( int n=lt+1; n<=lt+msgs.length && n<=timestamp; n++ ) {
                msgs[n % msgs.length].clear();
            }
        }

        boolean sp = true;

        for ( int n = timestamp; n < timestamp+msgs.length; n++ ) {
            int x1 = n % msgs.length;
            if ( msgs[x1].contains(message) ) {
                sp = false;
                break;
            }
        }

        if ( sp ) {
            msgs[x].add(message);
        }

        lt = timestamp;
        return sp;
    }

    public static void main( String arg[] ) {
        LoggerRate lr = new LoggerRate();
        boolean v;

        v = lr.shouldPrintMessage(100, "bug");
        out.println("v: " + v);

        v = lr.shouldPrintMessage(111, "bug");
        out.println("v: " + v);
    }
}
