package com.nwshire.coderbyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringReductionTest {

    @Test
    public void stringReduction() {
        String result = StringReduction.StringReduction("abcabc");
        assertEquals("2", result);

        result = StringReduction.StringReduction("cccc");
        assertEquals("4", result);
    }
}