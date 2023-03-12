package com.nwshire.coderbyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinWindowSubstringTest {

    @Test
    public void minWindowSubstring() {

        String result = MinWindowSubstring.minWindowSubstring("abadcdeageafl", "age");

        System.out.println(result);
    }
}