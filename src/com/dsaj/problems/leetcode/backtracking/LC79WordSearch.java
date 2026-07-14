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

class LC79WordSearchAltSolution {
    private final int[][] directions = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            return false;
        }

        if (word.isEmpty()) {
            return true;
        }

        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == chars[0] && backtrack(board, chars, row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, char[] word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word[index]) {
            return false;
        }

        visited[row][col] = true;

        for (int[] direction : directions) {
            if (backtrack(board, word, row + direction[0], col + direction[1], index + 1, visited)) {
                return true;
            }
        }

        visited[row][col] = false;
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
