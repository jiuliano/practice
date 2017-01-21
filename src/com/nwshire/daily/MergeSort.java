package com.nwshire.daily;

import java.util.Arrays;

/**
 * Created by james on 1/19/2017.
 */
public class MergeSort {
    public void mergeSort(String list[]) {
        mergeSort(list, 0, list.length-1);
    }

    private void mergeSort(String list[], int from, int to) {
        if ( to - from > 1 ) {
            int mid = from + ((to-from)/2);
            mergeSort(list, from, mid);
            mergeSort(list, mid+1, to);
            merge(list, from, mid, mid+1, to);
        } else if ( to - from == 1 && list[from].compareTo(list[to]) > 0 ) {
            String temp = list[from];
            list[from] = list[to];
            list[to] = temp;
        }
    }

    private void merge(String list[], int f1, int t1, int f2, int t2) {
        String temp[] = Arrays.copyOfRange(list, f1, t1+1);
        int f = 0;

        while ( f < temp.length || f2 <= t2 ) {
            if ( f < temp.length && f2 <= t2 ) {
                if ( temp[f].compareTo(list[f2]) > 0 ) {
                    list[f1++] = list[f2++];
                } else {
                    list[f1++] = temp[f++];
                }
            } else if ( f < temp.length ) {
                list[f1++] = temp[f++];
            } else {
                list[f1++] = list[f2++];
            }
        }
    }
}
