package com.nwshire;

/**
 * Created by james on 5/23/2016.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2, 8));
        intervals.add(new Interval(6, 10));
        intervals.add(new Interval(12, 15));
        intervals.add(new Interval(18, 20));

        MergeIntervals mi = new MergeIntervals();
        intervals = mi.merge(intervals);

        System.out.println("Result: ");
        for ( Interval interval : intervals ) {
            System.out.print(interval.toString() + " ");
        }

        System.out.println();
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> merged = null;

        if ( intervals != null && intervals.size() > 1 ) {
            Interval[] sortedIntervals = getSortedIntervals(intervals);

            merged = new ArrayList<Interval>();
            Interval lastInterval = null;

            for ( int n=0; n<sortedIntervals.length; n++ ) {
                if ( lastInterval == null ) {
                    lastInterval = sortedIntervals[n];
                } else {
                    if ( sortedIntervals[n].start > lastInterval.end ) {
                        merged.add(lastInterval);
                        lastInterval = sortedIntervals[n];
                    } else {
                        lastInterval.end = Math.max(lastInterval.end, sortedIntervals[n].end);
                    }
                }
            }

            if ( lastInterval != null ) {
                merged.add(lastInterval);
            }
        } else if ( intervals.size() == 1 ) {
            merged = intervals;
        }

        return merged;
    }

    private Interval[] getSortedIntervals(List<Interval> intervals) {
        Interval[] sortedIntervals = intervals.toArray(new Interval[0]);
        mergeSort(sortedIntervals, 0, sortedIntervals.length);
        return sortedIntervals;
    }

    private void mergeSort(Interval[] intervals, int from, int to) {
        if ( to - from > 1 ) {
            int mid = from + (to-from)/2;
            mergeSort(intervals, from, mid);
            mergeSort(intervals, mid, to);
            merge(intervals, from, mid, to);
        }
    }

    private void merge(Interval[] intervals, int from, int mid, int to) {
        Interval[] one = getSub(intervals, from, mid);
        Interval[] two = getSub(intervals, mid, to);

        int ox = 0;
        int tx = 0;
        int x = from;

        while ( ox < one.length && tx < two.length ) {
            if ( one[ox].start < two[tx].start ) {
                intervals[x++] = one[ox++];
            } else {
                intervals[x++] = two[tx++];
            }
        }

        while ( ox < one.length ) {
            intervals[x++] = one[ox++];
        }

        while ( tx < two.length ) {
            intervals[x++] = two[tx++];
        }
    }

    private Interval[] getSub(Interval[] intervals, int from, int to) {
        Interval[] sub = new Interval[to-from];

        for ( int n=from; n<to; n++ )
        {
            sub[n-from] = intervals[n];
        }

        return sub;
    }

    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
        public String toString() {
            return "[" + start + ", " + end + "]";
        }
    }
}