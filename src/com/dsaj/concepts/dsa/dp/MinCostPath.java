package com.dsaj.concepts.dsa.dp;

import java.util.Random;

import com.dsaj.concepts.dsa.utils.SystemUtils;

interface McpSolution {
    int minCostPath(int[][] matrix);
}

class McpRecursiveSolution implements McpSolution {
    private int minCostPathHelper(int[][] matrix, int atRow, int atCol) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        if (atRow == rows && atCol == cols) {
            return matrix[atRow][atCol];
        }

        if (atRow > rows || atCol > cols) {
            return Integer.MAX_VALUE;
        }

        int path1 = minCostPathHelper(matrix, atRow, atCol + 1);
        int path2 = minCostPathHelper(matrix, atRow + 1, atCol + 1);
        int path3 = minCostPathHelper(matrix, atRow + 1, atCol);

        return matrix[atRow][atCol] + Math.min(path1, Math.min(path2, path3));
    }

    public int minCostPath(int[][] martix) {
        return minCostPathHelper(martix, 0, 0);
    }
}

class McpMemoizationSolution implements McpSolution {
    private int minCostPathHelper(int[][] matrix, int[][] memo, int atRow, int atCol) {
        int rows = matrix.length - 1;
        int cols = matrix[0].length - 1;

        if (atRow == rows && atCol == cols) {
            memo[atRow][atCol] = matrix[atRow][atCol];
            return matrix[atRow][atCol];
        }

        if (atRow > rows || atCol > cols) {
            return Integer.MAX_VALUE;
        }

        if (memo[atRow][atCol] > 0) {
            return memo[atRow][atCol];
        }

        int path1 = minCostPathHelper(matrix, memo, atRow, atCol + 1);
        int path2 = minCostPathHelper(matrix, memo, atRow + 1, atCol + 1);
        int path3 = minCostPathHelper(matrix, memo, atRow + 1, atCol);

        memo[atRow][atCol] = matrix[atRow][atCol] + Math.min(path1, Math.min(path2, path3));

        return memo[atRow][atCol];
    }

    public int minCostPath(int[][] martix) {
        int[][] memo = new int[martix.length][martix[0].length];

        return minCostPathHelper(martix, memo, 0, 0);
    }
}

class McpDynamicProgrammingSolution implements McpSolution {
    public int minCostPath(int[][] martix) {
        int rows = martix.length;
        int cols = martix[0].length;

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j == cols - 1) {
                    continue;
                }

                int path1 = j + 1 < cols ? martix[i][j + 1] : Integer.MAX_VALUE;
                int path2 = (i + 1 < rows && j + 1 < cols) ? martix[i + 1][j + 1] : Integer.MAX_VALUE;
                int path3 = i + 1 < rows ? martix[i + 1][j] : Integer.MAX_VALUE;

                martix[i][j] += Math.min(path1, Math.min(path2, path3));
            }
        }

        return martix[0][0];
    }
}

public class MinCostPath {

    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static int[][] generateMatrix(int r, int c) {
        Random random = new Random();
        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = random.nextInt(1000) + 1; // range: 1 to 1000
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        // McpSolution solution = new McpRecursiveSolution();
        McpSolution solution2 = new McpMemoizationSolution();
        McpSolution solution3 = new McpDynamicProgrammingSolution();

        int row = SystemUtils.takeIntInput("Enter number of rows: ");
        int col = SystemUtils.takeIntInput("Enter number of columns: ");
        int[][] matrix = generateMatrix(row, col);

        // printMatrix(matrix);

        int ans;

        // Long startTime = System.currentTimeMillis();
        // ans = solution.minCostPath(matrix);
        // System.out.println("Min cost path: " + ans);
        // Long endTime = System.currentTimeMillis();
        // System.out.println("Time taken for recursive solution: " + (endTime - startTime) + " ms");

        Long memoStartTime = System.currentTimeMillis();
        ans = solution2.minCostPath(matrix);
        System.out.println("Min cost path: " + ans);
        Long memoEndTime = System.currentTimeMillis();
        System.out.println("Time taken for memoization solution: " + (memoEndTime - memoStartTime) + " ms");

        Long dpStartTime = System.currentTimeMillis();
        ans = solution3.minCostPath(matrix);
        System.out.println("Min cost path: " + ans);
        Long dpEndTime = System.currentTimeMillis();
        System.out.println("Time taken for dynamic programming solution: " + (dpEndTime - dpStartTime) + " ms");
    }
}
