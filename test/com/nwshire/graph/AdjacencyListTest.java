package com.nwshire.graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/14/2017.
 */
public class AdjacencyListTest {
    AdjacencyList al;

    @Before
    public void setUp() throws Exception {
        al = new AdjacencyList(10, false);
    }

    @Test
    public void addEdge() throws Exception {
        al.addEdge(0,4);
        al.addEdge(1,3);

        assertTrue(al.edgeExists(4,0));
        assertTrue(al.edgeExists(3,1));
        assertTrue(al.edgeExists(0,4));
    }
}