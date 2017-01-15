package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/14/2017.
 */
public class EvaluateDivisionTest {
    @Test
    public void calcEquation() throws Exception {
        String equations[][] = new String[][] {{"x1","x2"},{"x2","x3"},{"x1","x4"},{"x2","x5"}};
        double values[] = new double[] {3.0,0.5,3.4,5.6};
        String queries[][] = new String[][] {{"x2","x4"},{"x1","x5"},{"x1","x3"},{"x5","x5"},{"x5","x1"},{"x3","x4"},{"x4","x3"},{"x6","x6"},{"x0","x0"}};

        EvaluateDivision ev = new EvaluateDivision();
        double[] results = ev.calcEquation(equations, values, queries);

        assertEquals(results.length, 9);
        assertEquals(results[0], 1.133, 0.001);
        assertEquals(results[1], 16.799, 0.001);
        assertEquals(results[2], 1.5, 0.001);
        assertEquals(results[3], 1.0, 0.001);
        assertEquals(results[4], 0.059, 0.001);
        assertEquals(results[5], 2.266, 0.001);
        assertEquals(results[6], 0.441, 0.001);
        assertEquals(results[7], -1.0, 0.001);
        assertEquals(results[8], -1.0, 0.001);
    }

}