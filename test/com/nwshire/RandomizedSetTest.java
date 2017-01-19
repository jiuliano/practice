package com.nwshire;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/17/2017.
 */
public class RandomizedSetTest {
    @Test
    public void getRandom() throws Exception {
        RandomizedSet rs = new RandomizedSet();

        assertTrue(rs.insert(1));
        assertFalse(rs.remove(2));
        assertTrue(rs.insert(2));

        System.out.println("Random value: " + rs.getRandom());
        System.out.println("Random value: " + rs.getRandom());
        System.out.println("Random value: " + rs.getRandom());
        System.out.println("Random value: " + rs.getRandom());
        System.out.println("Random value: " + rs.getRandom());
        System.out.println("Random value: " + rs.getRandom());
        System.out.println("Random value: " + rs.getRandom());
        System.out.println("Random value: " + rs.getRandom());

        assertTrue(rs.remove(1));
        assertFalse(rs.insert(2));
    }
}