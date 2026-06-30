package com.dsaj.problems.leetcode.graph;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC695MaxAreaOfIslandSolution {

    int countedArea = 0;
    private void countArea(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if(grid[i][j] == 0) {
            return;
        }

        if (grid[i][j] == 1) {
            countedArea++;
            grid[i][j] = 0;
        }

        countArea(grid, i + 1, j);
        countArea(grid, i, j + 1);
        countArea(grid, i, j - 1);
        countArea(grid, i - 1, j);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    // count the island size
                    countedArea = 0;
                    countArea(grid, i, j);
                    maxArea = Math.max(maxArea, countedArea);
                }
            }
        }

        return maxArea;
    }
}

public class LC695MaxAreaOfIsland {
    public static void main(String[] args) {
        LC695MaxAreaOfIslandSolution solution = new LC695MaxAreaOfIslandSolution();

        int n = SystemUtils.takeIntInput("Enter number of rows: ");
        int m = SystemUtils.takeIntInput("Enter number of columns: ");
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = SystemUtils.takeIntArrayInputofSize("Enter row " + (i + 1) + " (as a string of '0's and '1's): ", m);
        }

        System.out.println("Max area of island: " + solution.maxAreaOfIsland(grid));
    }
}
