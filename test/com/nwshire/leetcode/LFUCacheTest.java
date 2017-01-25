package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/24/2017.
 */
public class LFUCacheTest {

    @Test
    public void test() {
        LFUCache cache = new LFUCache( 2 /* capacity */ );

        cache.put(3, 1);
        cache.put(2, 1);
        cache.put(2, 2);
        cache.put(4, 4);
        assertEquals(cache.get(2), 2);


        cache = new LFUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(cache.get(1), 1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        assertEquals(cache.get(2), -1);       // returns -1 (not found)
        assertEquals(cache.get(3), 3);       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        assertEquals(cache.get(1), -1);       // returns -1 (not found)
        assertEquals(cache.get(3), 3);       // returns 3
        assertEquals(cache.get(4), 4);       // returns 4
    }

}