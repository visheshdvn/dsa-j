package com.dsaj.problems.leetcode.math;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC73SetMatrixZeroesSolution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;

                    if (j == 0) {
                        col0 = 0;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != 0 && (matrix[0][j] == 0 || matrix[i][0] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

public class LC73SetMatrixZeroes {

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

    public static void main(String[] args) {
        // int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        int row = SystemUtils.takeIntInput("Enter number of rows: ");
        int col = SystemUtils.takeIntInput("Enter number of columns: ");

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = SystemUtils.takeIntArrayInputofSize("Enter elements of row " + i + " separated by space: ", col);
        }

        printMatrix(matrix);
        System.out.println("Setting zeroes in the matrix...");
        LC73SetMatrixZeroesSolution solution = new LC73SetMatrixZeroesSolution();
        solution.setZeroes(matrix);
        printMatrix(matrix);
    }
}
