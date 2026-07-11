package com.dsaj.problems.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC130SurroundingRegionsSolution {

    boolean[][] visited;
    boolean boundryFound = false;
    Queue<int[]> queue = new LinkedList<>();

    public void markRegion(char[][] board, int i, int j) {
        if (i == 0 || j == 0 || i >= board.length - 1 || j >= board[0].length - 1) {
            if (board[i][j] == 'O') {
                boundryFound = true;
            }
            return;
        }

        if (visited[i][j] || board[i][j] == 'X') {
            return;
        }

        if (board[i][j] == 'O') {
            visited[i][j] = true;
            board[i][j] = 'X';
            queue.add(new int[] { i, j });
        }

        markRegion(board, i + 1, j);
        markRegion(board, i, j + 1);
        markRegion(board, i, j - 1);
        markRegion(board, i - 1, j);
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (board[i][j] == 'O' && !visited[i][j]) {
                    boundryFound = false;
                    queue = new LinkedList<>();
                    markRegion(board, i, j);
                }

                if (boundryFound) {
                    while (!queue.isEmpty()) {
                        int[] coordinates = queue.poll();
                        int row = coordinates[0];
                        int col = coordinates[1];
                        board[row][col] = 'O';
                    }
                }
            }
        }
    }
}


/*
This solution optimizes the time complexity by iterating over the boundary of the board and marking the 'O's that are connected to the boundary.
This way one cell is only visited once and the time complexity is O(m*n) where m is the number of rows and n is the number of columns.
 */
class LC130SurroundingRegionsOptimizedSolution {

    int[][] visited;

    public void markRegion(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }

        if (visited[i][j] == 1 || board[i][j] == 'X') {
            return;
        }

        if (board[i][j] == 'O') {
            visited[i][j] = 1;
        }

        markRegion(board, i + 1, j);
        markRegion(board, i, j + 1);
        markRegion(board, i, j - 1);
        markRegion(board, i - 1, j);
    }

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        visited = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            // iterating first column
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                markRegion(board, i, 0);
            }

            // iterating last column
            if (board[i][cols - 1] == 'O' && visited[i][cols - 1] == 0) {
                markRegion(board, i, cols - 1);
            }
        }

        for (int i = 0; i < cols; i++) {
            // iterating first row
            if (board[0][i] == 'O' && visited[0][i] == 0) {
                markRegion(board, 0, i);
            }

            // iterating last row
            if (board[rows - 1][i] == 'O' && visited[rows - 1][i] == 0) {
                markRegion(board, rows - 1, i);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

public class LC130SurroundingRegions {

    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(new String(row));
        }
    }

    public static void main(String[] args) {
        int rows = SystemUtils.takeIntInput("Enter number of rows: ");
        int cols = SystemUtils.takeIntInput("Enter number of columns: ");

        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            board[i] = SystemUtils
                    .takeCharArrayInputOfSize("Enter row " + (i + 1) + " (as a string of 'X's and 'O's): ", cols);
        }

        System.out.println("Original Board: ");
        printBoard(board);

        LC130SurroundingRegionsOptimizedSolution solution = new LC130SurroundingRegionsOptimizedSolution();
        solution.solve(board);

        System.out.println("Board after solving: ");
        printBoard(board);
    }
}

// [
// ["O","O","O","O","X","X"],
// ["O","O","O","O","O","O"],
// ["O","X","O","X","O","O"],
// ["O","X","O","O","X","O"],
// ["O","X","O","X","O","O"],
// ["O","X","O","O","O","O"]
// ]