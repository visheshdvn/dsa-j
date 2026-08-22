package com.dsaj.problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class LC994RottingOrangesSolution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int time = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            Queue<int[]> innerQueue = new ArrayDeque<>();

            while (!queue.isEmpty()) {
                int[] coordinate = queue.poll();
                int row = coordinate[0];
                int col = coordinate[1];

                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    innerQueue.offer(new int[] { row, col - 1 });
                }

                if (col + 1 < cols && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    innerQueue.offer(new int[] { row, col + 1 });
                }

                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    innerQueue.offer(new int[] { row - 1, col });
                }

                if (row + 1 < rows && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    innerQueue.offer(new int[] { row + 1, col });
                }
            }
            if (innerQueue.size() > 0) {
                time++;
            }
            queue = innerQueue;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }
}

public class LC994RottingOranges {
    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 1 }, { 0, 1, 2 } };
        System.out
                .println("minimum time to rot all oranges: " + new LC994RottingOrangesSolution().orangesRotting(grid));
    }
}