package com.dsaj.problems.leetcode.arrays;


class LC36ValidSudokuSolution {

    public boolean isValidSudoku(char[][] board) {
        int[] digits;

        // check for squares
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {

                digits = new int[9];
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (board[k][l] != '.') {
                            if(digits[board[k][l] - '1'] == 1) {
                                return false;
                            }
                            digits[board[k][l] - '1'] = 1;
                        }
                    }
                }
            }
        }

        // check for rows
        for (int i = 0; i < 9; i++) {

            digits = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (digits[board[i][j] - '1'] == 1) {
                        return false;
                    }
                    digits[board[i][j] - '1'] = 1;
                }
            }
        }

        // check for columns
        for (int j = 0; j < 9; j++) {
            
            digits = new int[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (digits[board[i][j] - '1'] == 1) {
                        return false;
                    }
                    digits[board[i][j] - '1'] = 1;
                }
            }
        }

        return true;
    }
}

public class LC36ValidSudoku {
    public static void main(String[] args) {
        LC36ValidSudokuSolution solution = new LC36ValidSudokuSolution();
        // System.out.println('1' - '1');

        char[][] board = {  {'5','3','.','.','7','.','.','.','.'},
                            {'6','.','.','1','9','5','.','.','.'},
                            {'.','9','8','.','.','.','.','6','.'},
                            {'8','.','.','.','6','.','.','.','3'},
                            {'4','.','.','8','.','3','.','.','1'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','6','.','.','.','.','2','8','.'},
                            {'.','.','.','4','1','9','.','.','5'},
                            {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(solution.isValidSudoku(board));
    }
}
