package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC200NumberOfIslandsSolution {

    private void markIsland(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] == '0' || grid[i][j] == '*') {
            return;
        }

        if(grid[i][j] == '1') {
            grid[i][j] = '*';
        }

        markIsland(grid, i + 1, j);
        markIsland(grid, i, j + 1);
        markIsland(grid, i, j - 1);
        markIsland(grid, i - 1, j);
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    // run dfs from this index
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }
}

public class LC200NumberOfIslands {

    public static void main(String[] args) {
        LC200NumberOfIslandsSolution solution = new LC200NumberOfIslandsSolution();

        int n = SystemUtils.takeIntInput("Enter number of rows: ");
        int m = SystemUtils.takeIntInput("Enter number of columns: ");
        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = SystemUtils.takeCharArrayInputOfSize("Enter row " + (i + 1) + " (as a string of '0's and '1's): ", m);
        }

        System.out.println("Number of islands: " + solution.numIslands(grid));
    }
}
