package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/14/2017.
 */
public class EvaluateDivisionTest {
    @Test
    public void calcEquation() throws Exception {
        //String equations[][] = new String[][] { {"a", "b"}, {"b", "c"} };
        //double values[] = new double[] { 2.0, 3.0 };
        //String queries[][] = new String[][] { {"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };

        String equations[][] = new String[][] {{"x1","x2"},{"x2","x3"},{"x1","x4"},{"x2","x5"}};
        double values[] = new double[] {3.0,0.5,3.4,5.6};
        String queries[][] = new String[][] {{"x2","x4"},{"x1","x5"},{"x1","x3"},{"x5","x5"},{"x5","x1"},{"x3","x4"},{"x4","x3"},{"x6","x6"},{"x0","x0"}};

        EvaluateDivision ev = new EvaluateDivision();
        ev.calcEquation(equations, values, queries);
    }

}