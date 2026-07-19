package com.dsaj.problems.leetcode.stack;

import java.util.Stack;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC150EvaluateReversePolishNotationSolution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "+": {
                        stack.push(stack.pop() + stack.pop());
                    }
                    break;
                case "-": {
                        int r = stack.pop();
                        int l = stack.pop();
                        stack.push(l-r);
                    }
                    break;
                case "*": {
                        stack.push(stack.pop()*stack.pop());
                    }
                    break;
                case "/": {
                        int r = stack.pop();
                        int l = stack.pop();
                        stack.push(l/r);
                    }
                    break;
                default:
                    stack.push(Integer.valueOf(tokens[i]));
                    break;
            }
        }

        return stack.pop();
    }
}

public class LC150EvaluateReversePolishNotation {
    public static void main(String[] args) {
        LC150EvaluateReversePolishNotationSolution solution = new LC150EvaluateReversePolishNotationSolution();

        String[] tokens = SystemUtils.takeStringArrayInput("Enter tokens: ");

        int result = solution.evalRPN(tokens);
        System.out.println("Result: " + result);
    }
}