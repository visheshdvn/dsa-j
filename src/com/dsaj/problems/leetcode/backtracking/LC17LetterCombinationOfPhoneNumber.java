package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC17LetterCombinationOfPhoneNumberSolution {
    String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    private void backtrack(char[] digits, List<String> combinations, StringBuilder current, int start) {
        if (start >= digits.length) {
            combinations.add(new String(current));
            return;
        }

        char[] alphas = keypad[digits[start] - '0'].toCharArray();

        for (int j = 0; j < alphas.length; j++) {
            current.append(alphas[j]);
            backtrack(digits, combinations, current, start + 1);
            current.setLength(current.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        backtrack(digits.toCharArray(), combinations, new StringBuilder(""), 0);

        return combinations;
    }
}

public class LC17LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        String digits = SystemUtils.takeStringInput("Enter the digits: ");

        List<String> combinations = new LC17LetterCombinationOfPhoneNumberSolution().letterCombinations(digits);

        ArrayUtils.printList(combinations);
    }
}
