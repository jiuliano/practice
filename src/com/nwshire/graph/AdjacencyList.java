package com.nwshire.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by james on 1/14/2017.
 */
public class AdjacencyList {
    Set<Integer> aList[];
    boolean directed;

    public AdjacencyList(int size, boolean directed) {
        aList = new Set[size];
        this.directed = directed;
    }

    public void addEdge(int v1, int v2) throws Exception {
        addEdge(v1, v2, directed);
    }

    public void removeEdge(int v1, int v2) throws Exception {
        removeEdge(v1, v2, directed);
    }

    public boolean edgeExists(int v1, int v2) throws Exception {
        validate(v1,v2);
        return aList[v1] != null && aList[v1].contains(v2);
    }

    private void validate(int v1, int v2) throws Exception {
        if  ( v1 < 0 || v1 >= aList.length && v2 < 0 && v2 >= aList.length ) {
            throw new Exception("Verteces out of range");
        }
    }

    private void addEdge(int v1, int v2, boolean directed) throws Exception {
        validate(v1,v2);

        if ( aList[v1] == null ) {
            aList[v1] = new HashSet<Integer>();
        }

        aList[v1].add(v2);

        if ( !directed ) {
            addEdge(v2, v1, true);
        }
    }

    private void removeEdge(int v1, int v2, boolean directed) throws Exception {
        validate(v1,v2);

        if ( aList[v1] != null ) {
            aList[v1].remove(v2);
        }

        if ( !directed ) {
            removeEdge(v2, v1, true);
        }
    }
}
