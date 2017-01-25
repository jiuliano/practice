package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/24/2017.
 */
public class NumIslandsTest {
    @Test
    public void numIslands() throws Exception {
        NumIslands ni = new NumIslands();

        char[][] grid = {
                { '1', '1', '1' },
                { '0', '1', '0' },
                { '1', '1', '1' }
        };

        int islands = ni.numIslands(grid);
        assertEquals(islands, 1);
    }

}