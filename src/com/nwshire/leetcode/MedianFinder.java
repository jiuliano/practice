package com.nwshire.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 5/31/2016.
 */
public class MedianFinder {
    List<Integer> queue = new ArrayList<Integer>();

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.findMedian();
        mf.addNum(10);
        mf.findMedian();
        mf.addNum(2);
        mf.findMedian();
        mf.addNum(6);
        mf.findMedian();
        mf.addNum(5);
        mf.findMedian();
        mf.addNum(0);
        mf.findMedian();
        mf.addNum(6);
        mf.findMedian();
        mf.addNum(3);
        mf.findMedian();
        mf.addNum(1);
        mf.findMedian();
        mf.addNum(0);
        mf.findMedian();
        mf.addNum(0);
        mf.findMedian();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        int idx = findIdx(queue, num, 0, queue.size());
        if ( idx >= queue.size() ) {
            queue.add(num);
        } else {
            queue.add(idx, num);
        }
    }

    int findIdx(List<Integer> queue, int value, int from, int to) {
        int idx;

        if ( to <= from ) {
            idx = from;
        } else {
            idx = from + ((to - from) / 2);
            if (idx != from) {
                int qval = queue.get(idx);
                if (value > qval) {
                    idx = findIdx(queue, value, idx + 1, to);
                } else {
                    idx = findIdx(queue, value, from, idx);
                }
            } else {
                while ( idx < queue.size() && queue.get(idx) < value ) {
                    idx++;
                }
            }
        }

        return idx;
    }

    // Returns the median of current data stream
    public double findMedian() {
        double result = 0.0;
        int size = queue.size();
        int medidx = size / 2;

        if ( size % 2 == 0 && size >= 2 ) {
            result = ((double)( queue.get(medidx-1) + queue.get(medidx) )) / 2.0;
        } else if ( size >= 1 ) {
            result = (double)queue.get(medidx);
        }

        return result;
    }
}
