package com.nwshire.cracking;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/21/2017.
 */
public class SetOfStacksTest {
    @Test
    public void test() throws Exception {
        SetOfStacks<Integer> sos = new SetOfStacks<>();

        sos.push(50);
        sos.push(40);
        sos.push(20);
        sos.push(100);
        sos.push(120);
        sos.push(900);
        sos.push(30);
        sos.push(35);
        sos.push(25);
        sos.push(47);

        sos.push(500);
        sos.push(300);
        sos.push(44);
        sos.push(80);

        Integer value = sos.pop();
        assertEquals((int)value, 80);

        value = sos.popAt(1);
        assertEquals((int)value, 47);

        value = sos.popAt(1);
        assertEquals((int)value, 25);

        value = sos.popAt(0);
        assertEquals((int)value, 44);
    }

}