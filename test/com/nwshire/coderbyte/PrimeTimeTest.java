package com.nwshire.coderbyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeTimeTest {

    @Test
    public void primeTime() {
        String result = PrimeTime.PrimeTime(11);
        assertEquals("true", result);

        result = PrimeTime.PrimeTime(12);
        assertEquals("false", result);

        result = PrimeTime.PrimeTime(100);
        assertEquals("false", result);
    }
}