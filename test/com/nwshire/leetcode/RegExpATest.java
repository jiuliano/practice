package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/15/2017.
 */
public class RegExpATest {
    @Test
    public void isMatch() throws Exception {
        RegExpA rea = new RegExpA();

        assertFalse(rea.isMatch("aa","a"));
        assertTrue(rea.isMatch("aa","aa"));
        assertFalse(rea.isMatch("aaa","aa"));
        assertTrue(rea.isMatch("aa", "a*"));
        assertTrue(rea.isMatch("aa", ".*"));
        assertTrue(rea.isMatch("ab", ".*"));
        assertTrue(rea.isMatch("aab", "c*a*b"));
        assertFalse(rea.isMatch("ab", ".*c"));
        assertTrue(rea.isMatch("a", "ab*"));
        assertFalse(rea.isMatch("a", "ab*a"));
    }
}