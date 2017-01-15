package com.nwshire.hrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by james on 1/13/2017.
 */
public class Liars {
    private static int soldiers;
    private static Dataset sets[];

    public static void main( String args[] )
    {
        //String temp[] = { "a", "b", "c" };
        //loadFromInput();

        soldiers = 20;
        sets = new Dataset[11];
        int i = 0;
        sets[i++] = new Dataset(3,8,4);
        sets[i++] = new Dataset(1,9,6);
        sets[i++] = new Dataset(1,13,9);
        sets[i++] = new Dataset(5,11,5);
        sets[i++] = new Dataset(4,19,12);
        sets[i++] = new Dataset(8,13,5);
        sets[i++] = new Dataset(4,8,4);
        sets[i++] = new Dataset(7,9,2);
        sets[i++] = new Dataset(10,13,3);
        sets[i++] = new Dataset(7,16,7);
        sets[i++] = new Dataset(14,19,4);

        run(soldiers, sets);

        soldiers = 3;
        sets = new Dataset[2];
        i = 0;
        sets[i++] = new Dataset(1,2,1);
        sets[i++] = new Dataset(2,3,1);

        run(soldiers, sets);
    }


    private static void run(int soldiers, Dataset sets[]) {
        int minLiars = 0, maxLiars = 0;

        Edge graph[] = new Edge[soldiers];
        for ( int n=0; n<soldiers; n++ ) {
            graph[n] = null;
        }

        for ( int x=0; x<sets.length; x++ ) {
            Dataset dataSet = sets[x];
            int weight = (dataSet.liars * 1000) / (dataSet.to - dataSet.from + 1);

            for ( int n=dataSet.from; n<=dataSet.to; n++ ) {
                if ( graph[n-1] == null ) {
                    graph[n-1] = new Edge();
                    graph[n-1].min = weight;
                    graph[n-1].max = weight;
                } else {
                    if ( graph[n-1].min > weight ) {
                        graph[n-1].min = weight;
                    }

                    if ( graph[n-1].max < weight ) {
                        graph[n-1].max = weight;
                    }
                }
            }
        }

        for ( int x=0; x<soldiers; x++ ) {
            if ( graph[x] != null ) {
                minLiars += graph[x].min;
                maxLiars += graph[x].max;
            }
        }

        System.out.println( (minLiars+500)/1000 + " " + (maxLiars-500)/1000 );
    }

    private static void loadFromInput() {
        // helpers for input/output
        Scanner in = new Scanner(System.in);

        soldiers = in.nextInt();
        int datasets = in.nextInt();

        sets = new Dataset[datasets];

        for(int i=0; i<datasets; i++)
        {
            sets[i] = new Dataset(in.nextInt(), in.nextInt(), in.nextInt());
        }
    }

    private static class Edge {
        int min;
        int max;
    }

    private static class Dataset {
        int from;
        int to;
        int liars;

        private Dataset(int from, int to, int liars) {
            this.from = from;
            this.to = to;
            this.liars = liars;
        }
    }
}
