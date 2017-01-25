package com.nwshire.leetcode;

/**
 * Created by james on 1/24/2017.
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int islands = 0;

        for ( int r=0; r<grid.length; r++ ) {
            for ( int c=0; c<grid[0].length; c++ ) {
                if ( grid[r][c] == '1' ) {
                    ++islands;
                    visit(grid, r, c);
                }
            }
        }

        return islands;
    }

    void visit(char[][] grid, int r, int c) {
        while ( c-1 >= 0 && grid[r][c-1] == '1' ) --c;

        while ( c < grid[0].length && grid[r][c] == '1' ) {
            grid[r][c] = '2';
            if ( r+1 < grid.length && grid[r+1][c] == '1' ) {
                visit(grid, r+1, c);
            }

            if ( r-1 >= 0 && grid[r-1][c] == '1' ) {
                visit(grid, r-1, c);
            }

            ++c;
        }
    }
}
