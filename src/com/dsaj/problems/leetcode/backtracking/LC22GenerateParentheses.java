package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC22GenerateParenthesesSolution {
    public void generateParenthesisHelper(List<String> result, int n1, int n2, StringBuilder currentString) {

        if(n1 == 0 && n2 == 0) {
            result.add(currentString.toString());
            return;
        }

        if(n1 == n2) {
            generateParenthesisHelper(result, n1-1, n2, currentString.append("("));
            currentString.setLength(currentString.length() - 1);
        } else if(n1 < n2) {
            if(n1 != 0) {
                generateParenthesisHelper(result, n1-1, n2, currentString.append("("));

                currentString.setLength(currentString.length() - 1);
            }
            
            generateParenthesisHelper(result, n1, n2-1, currentString.append(")"));
            currentString.setLength(currentString.length() - 1);
        } else {
            generateParenthesisHelper(result, n1, n2-1, currentString.append(")"));
            currentString.setLength(currentString.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(result, n, n, new StringBuilder());
        return result;
    }
}

public class LC22GenerateParentheses {
    public static void main(String[] args) {
        LC22GenerateParenthesesSolution solution = new LC22GenerateParenthesesSolution();

        int n = SystemUtils.takeIntInput("Enter value of n: ");

        List<String> list = solution.generateParenthesis(n);
        
        ArrayUtils.printList(list);
    }
}
