package com.nwshire.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by james on 1/18/2017.
 */
public class TicTacToeTest {
    @Test
    public void move() throws Exception {
        TicTacToe ttt = new TicTacToe(3);

        assertEquals(ttt.move(0, 0, 1), 0);
        assertEquals(ttt.move(1, 0, 2), 0);
        assertEquals(ttt.move(0, 1, 1), 0);
        assertEquals(ttt.move(1, 1, 2), 0);
        assertEquals(ttt.move(0, 2, 1), 1);
        assertEquals(ttt.move(1, 2, 2), 1);

        // TODO: Add more tests to fully test all code paths.
    }

}