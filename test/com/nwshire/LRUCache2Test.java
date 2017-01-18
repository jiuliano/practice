package com.nwshire;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/18/2017.
 */
public class LRUCache2Test {
    @Test
    public void test() throws Exception {
        LRUCache2 lru2 = new LRUCache2(2);

        lru2.put("a", "abc");
        lru2.put("b", "bcd");
        assertEquals(lru2.get("a"), "abc");

        lru2.put("c", "xyz"); // evicts b
        assertNull(lru2.get("b"));
    }

}