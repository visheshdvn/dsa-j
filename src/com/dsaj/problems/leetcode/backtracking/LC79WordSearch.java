package com.dsaj.problems.leetcode.backtracking;

import com.dsaj.concepts.dsa.utils.SystemUtils;

// ["A","B","C","E"]
// ["S","F","E","S"]
// ["A","D","E","E"]

class LC79WordSearchSolution {

    boolean exists = false;

    private void backtrack(char[][] board, char[] chars, int row, int col, int idx, int[][] visited) {
        if(exists || row < 0 || col < 0 || board.length <= row || board[0].length <= col) {
            return;
        }

        if(board[row][col] != chars[idx]) {
            return;
        }

        if(visited[row][col] == 1) {
            return;
        }

        if(board[row][col] == chars[idx] && idx == chars.length -1) {
            exists = true;
            return;
        }

        visited[row][col] = 1;
        backtrack(board, chars, row, col+1, idx+1, visited);
        backtrack(board, chars, row, col-1, idx+1, visited);
        backtrack(board, chars, row+1, col, idx+1, visited);
        backtrack(board, chars, row-1, col, idx+1, visited);
        visited[row][col] = 0;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        char[] chars = word.toCharArray();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == chars[0]) {
                    backtrack(board, chars, i, j, 0, new int[rows][cols]);
                    if (exists) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

public class LC79WordSearch {
    public static void main(String[] args) {
        LC79WordSearchSolution solution = new LC79WordSearchSolution();

        int rows = SystemUtils.takeIntInput("Enter number of rows: ");
        int cols = SystemUtils.takeIntInput("Enter number of columns: ");

        char[][] board = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            board[i] = SystemUtils.takeCharArrayInputOfSize("Enter alphabets for row " + (i+1) + ": ", cols);
        }

        System.out.println("done");

        String word = SystemUtils.takeStringInput("Enter the word: ");

        System.out.println("Word exists: " + solution.exist(board, word));
    }
}

// [. . . . . .]
