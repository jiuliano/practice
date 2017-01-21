package com.nwshire.daily;

import java.util.Arrays;

/**
 * Created by james on 1/19/2017.
 */
public class MergeSort {
    public void mergeSort(String list[]) {
        mergeSort(list, 0, list.length-1);
    }

    private void mergeSort(String[] list, int from, int to) {
        if ( to - from < 2 ) {
            if ( list[from].compareTo(list[to]) > 0 ) {
                String temp = list[from];
                list[from] = list[to];
                list[to] = temp;
            }
        } else {
            int mid = from + (to-from)/2;
            mergeSort(list, from, mid);
            mergeSort(list, mid+1, to);
            merge(list, from, mid, mid+1, to);
        }
    }

    private void merge(String[] list, int f1, int t1, int f2, int t2) {
        String[] temp = Arrays.copyOfRange(list, f1, t1+1);
        int ft = 0;

        while ( ft < temp.length || f2 <= t2 ) {
            if ( ft < temp.length && f2 <= t2 ) {
                if ( temp[ft].compareTo(list[f2]) <= 0 ) {
                    list[f1++] = temp[ft++];
                } else {
                    list[f1++] = list[f2++];
                }
            } else if ( ft < temp.length ) {
                list[f1++] = temp[ft++];
            } else {
                list[f1++] = list[f2++];
            }
        }
    }
}
