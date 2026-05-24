package com.dsaj.problems.leetcode.dp;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC279Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j*j <= i; j++) {
                int rem = i - j*j;
                min = Math.min(min, dp[rem]);
            }

            dp[i] = min+1;
        }

        return dp[n];
    }
}

public class LC279PerfectSquares {
    public static void main(String[] args) {
        int n = SystemUtils.takeIntInput("Enter the number: ");

        System.out.println("min squares = " + (new LC279Solution()).numSquares(n));
    }
}
