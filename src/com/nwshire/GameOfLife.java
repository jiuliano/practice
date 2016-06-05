package com.nwshire;

/**
 * Created by james on 5/25/2016.
 */
public class GameOfLife {
    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();
        int[][] board = new int[][] {
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0 }
        };

        gol.gameOfLife(board);
    }

    public void gameOfLife(int[][] board) {
        if ( board != null && board.length > 0 && board[0].length > 0 ) {
            int[][] lastBoard = new int[board.length][board[0].length];

            for ( int row=0; row<board.length; row++ ) {
                for ( int col=0; col<board[0].length; col++ ) {
                    lastBoard[row][col] = board[row][col];
                }
            }

            for ( int row=0; row<board.length; row++ ) {
                for ( int col=0; col<board[0].length; col++ ) {
                    int count = getNeighborCount(lastBoard, row, col);
                    if ( lastBoard[row][col] == 1 ) {
                        if ( count < 2 || count > 3 ) {
                            board[row][col] = 0;
                        }
                    } else if ( count == 3 ) {
                        board[row][col] = 1;
                    }
                }
            }
        }
    }

    int getNeighborCount(int[][] board, int row, int col) {
        int count = 0;

        for ( int r=row-1; r<=row+1; r++ ) {
            for ( int c=col-1; c<=col+1; c++ ) {
                if ( (r != row || c != col) && r >= 0 && r < board.length && c >= 0 && c < board[0].length ) {
                    count += board[r][c];
                }
            }
        }

        return count;
    }
}
