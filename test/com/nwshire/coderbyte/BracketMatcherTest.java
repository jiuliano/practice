package com.nwshire.coderbyte;

import org.junit.Test;

import static org.junit.Assert.*;

public class BracketMatcherTest {

    @Test
    public void bracketMatcher() {
        String result = BracketMatcher.BracketMatcher("(abc)");
        assertEquals("1", result);

        result = BracketMatcher.BracketMatcher("(coder)(byte))");
        assertEquals("0", result);
    }
}