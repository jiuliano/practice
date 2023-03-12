package com.nwshire.leetcode2019;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void lruTest() {
        int v;
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);

        v = cache.get(1);       // returns 1

        cache.put(3, 3);    // evicts key 2

        v = cache.get(2);       // returns -1 (not found)

        cache.put(4, 4);    // evicts key 1

        v = cache.get(1);       // returns -1 (not found)
        v = cache.get(3);       // returns 3
        v = cache.get(4);       // returns 4
    }
}