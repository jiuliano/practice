package com.nwshire.leetcode;

import java.util.Arrays;

/**
 * Created by james on 1/18/2017.
 */
public class TicTacToe {

    int gameWinner = 0;

    int rows[];
    int cols[];
    int diags[];
    int size;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        size = n;
        rows = new int[size];
        cols = new int[size];
        diags = new int[2];

        Arrays.fill(rows, 0);
        Arrays.fill(cols, 0);
        Arrays.fill(diags, 0);
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if ( gameWinner == 0 ) {
            int marker = player == 1 ? -1 : 1;

            rows[row] += marker;
            gameWinner = check(rows[row], player);

            if ( gameWinner == 0 ) {
                cols[col] += marker;
                gameWinner = check(cols[col], player);

                if ( gameWinner == 0 ) {
                    if (row == col) {
                        diags[0] += marker;
                        gameWinner = check(diags[0], player);
                    }

                    if ( gameWinner == 0 ) {
                        int acol = size - (col + 1);
                        if (row == acol) {
                            diags[1] += marker;
                            gameWinner = check(diags[1], player);
                        }
                    }
                }
            }
        }

        return gameWinner;
    }

    private int check(int score, int player) {
        return Math.abs(score) == size ? player : 0;
    }
}
