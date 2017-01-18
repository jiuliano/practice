package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/17/2017.
 */
public class LongestCommonPrefixTest {
    @Test
    public void longestCommonPrefix() throws Exception {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String words[] = new String[] { "dado", "dad", "day" };

        String prefix = lcp.longestCommonPrefix(words);
        assertEquals(prefix, "da");
    }
}