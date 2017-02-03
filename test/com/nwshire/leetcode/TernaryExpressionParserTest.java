package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 2/2/2017.
 */
public class TernaryExpressionParserTest {
    @Test
    public void parseTernary() throws Exception {
        TernaryExpressionParser tep = new TernaryExpressionParser();

        assertEquals(tep.parseTernary("T?2:3"), "2");
        assertEquals(tep.parseTernary("F?1:T?4:5"), "4");
        assertEquals(tep.parseTernary("T?T?F:5:3"), "F");
        assertEquals(tep.parseTernary("F?T:F?T?1:2:F?3:4"), "4");
    }

}