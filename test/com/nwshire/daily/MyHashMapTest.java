package com.nwshire.daily;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/20/2017.
 */
public class MyHashMapTest {
    @Test
    public void test() {
        MyHashMap<String,Integer> hashMap = new MyHashMap<>(103);

        hashMap.put("abc", 0);
        hashMap.put("bladeebla", 50);
        hashMap.put("cnn", 655);
        hashMap.put("velocity", 663);

        assertEquals((int)hashMap.get("abc"), 0);

        hashMap.put("abc", 5);

        assertEquals((int)hashMap.get("abc"), 5);

        hashMap.remove("abc");

        assertEquals(hashMap.get("abc"), null);
        assertEquals((int)hashMap.get("velocity"), 663);
        assertEquals(hashMap.get("noneja"), null);
    }
}