package com.nwshire.cracking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/21/2017.
 */
public class StackWithMinimumTest {
    @Test
    public void test() throws Exception {
        StackWithMinimum swm = new StackWithMinimum();

        swm.push(10);
        swm.push(5);
        swm.push(20);
        swm.push(50);
        swm.push(5);
        swm.push(2);
        swm.push(100);
        swm.push(99);

        assertEquals(swm.min(), 2);
        swm.pop(); // 99
        swm.pop(); // 100
        swm.pop(); // 2

        assertEquals(swm.min(), 5);

        swm.pop(); // 5
        swm.pop(); // 50
        swm.pop(); // 20
        assertEquals(swm.min(), 5);
    }

}