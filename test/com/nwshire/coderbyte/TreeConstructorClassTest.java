package com.nwshire.coderbyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeConstructorClassTest {

    @Test
    public void treeConstructor() {
        String result =
            TreeConstructorClass.TreeConstructor(new String[] {"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"});

        assertEquals("true", result);

        result =
            TreeConstructorClass.TreeConstructor(new String[] {"(1,2)", "(3,2)", "(2,12)", "(5,2)"});

        assertEquals("false", result);

        result =
            TreeConstructorClass.TreeConstructor(new String[] {"(10,20)", "(20,50)"});

        assertEquals("true", result);
    }
}