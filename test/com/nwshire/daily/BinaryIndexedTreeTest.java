package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/20/2017.
 */
public class BinaryIndexedTreeTest {
    @Test
    public void test() throws Exception {
        BinaryIndexedTree bit = new BinaryIndexedTree(4);

        bit.add(1, 1);
        bit.add(2, 3);
        bit.add(3, 5);

        assertEquals(bit.sum(3), 9);

        bit.add(2, -1);
        assertEquals(bit.sum(3), 8);
    }
}