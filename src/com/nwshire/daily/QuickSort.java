package com.nwshire.daily;

/**
 * Created by james on 1/19/2017.
 */
public class QuickSort {
    public void quickSort(String list[]) {
        quickSort(list, 0, list.length-1);
    }

    private void quickSort(String list[], int from, int pivot) {
        if ( pivot - from > 1 ) {
            int to = pivot-1;
            int fr = from;

            while ( fr < to ) {
                while ( fr < to && list[fr].compareTo(list[pivot]) < 0 ) {
                    ++fr;
                }

                while ( to > fr && list[to].compareTo(list[pivot]) > 0 ) {
                    --to;
                }

                if ( fr < to ) {
                    String temp = list[fr];
                    list[fr] = list[to];
                    list[to] = temp;
                }
            }

            String temp = list[pivot];
            list[pivot] = list[to];
            list[to] = temp;

            quickSort(list, from, to-1);
            quickSort(list, to+1, pivot);
        }
    }
}
