package com.dsaj.problems.leetcode.math;

import java.util.HashSet;
import java.util.Set;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC202HappyNumberSolution {
    private int getSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();

        while (n != 1) {
            if (visited.contains(n)) {
                return false;
            }

            visited.add(n);
            n = getSquareSum(n);
        }
        return true;
    }
}

public class LC202HappyNumber {
    public static void main(String[] args) {
        LC202HappyNumberSolution solution = new LC202HappyNumberSolution();
        // System.out.println(solution.isHappy(19)); // true
        // System.out.println(solution.isHappy(2)); // false
        // System.out.println(solution.isHappy(100));

        int n = SystemUtils.takeIntInput("Enter the number to check if it is happy or not: ");
        System.out.println(solution.isHappy(n));
    }
}
