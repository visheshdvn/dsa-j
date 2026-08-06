package com.dsaj.problems.leetcode.math;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC50PowSolution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // Convert to long so we can safely negate the exponent.
        // For n = Integer.MIN_VALUE, -n would overflow an int and stay negative,
        // which breaks the algorithm. Using long avoids this overflow.
        long power = (long) n;
        if (power < 0) {
            x = 1 / x;
            power *= -1;
        }

        double ans = 1L;
        while (power > 0) {
            if ((power & 1) == 1) {
                ans *= x;
            }
            x *= x;
            power = power >> 1;
        }
        return ans;
    }
}

class LC50PowWrongSolution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        // This version keeps the exponent as int.
        // When n = Integer.MIN_VALUE, negating it overflows and produces the same negative value,
        // so the loop never terminates correctly and the result is wrong.
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        double ans = 1L;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return ans;
    }
}

public class LC50Pow {
    public static void main(String[] args) {
        double x = SystemUtils.takeDoubleInput("Enter x: ");
        int n = SystemUtils.takeIntInput("Enter exponent: ");

        System.out.println("result: " + new LC50PowSolution().myPow(x, n));
        // System.out.println("result: " + new LC50PowSolution().myPow(2.00000, -2147483648));
        // System.out.println("result: " + new LC50PowWrongSolution().myPow(2.00000, -2147483648));
    }
}
