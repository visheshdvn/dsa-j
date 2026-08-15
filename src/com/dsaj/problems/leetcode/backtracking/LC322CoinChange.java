package com.dsaj.problems.leetcode.backtracking;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC322CoinChangeSolution {
    int nCoins = Integer.MAX_VALUE;
    boolean coinsUpdated = false;

    private void backtrack(int[] coins, int amount, int start, int currentAmount, int count) {
        if (currentAmount > amount || (coinsUpdated && count >= nCoins)) {
            return;
        }

        if (currentAmount == amount) {
            if (count < nCoins) {
                nCoins = count;
                coinsUpdated = true;
            }
            return;
        }

        for (int i = start; i < coins.length; i++) {
            backtrack(coins, amount, i, currentAmount + coins[i], count + 1);
            backtrack(coins, amount, i + 1, currentAmount, count);
        }
    }

    public int coinChange(int[] coins, int amount) {
        backtrack(coins, amount, 0, 0, 0);
        if (!coinsUpdated) {
            return -1;
        }
        return nCoins;
    }
}

// LC322CoinChangeSolutionDivisionApproach is an optimized version of the coin change problem that uses a backtracking approach
// with a division strategy. It sorts the coin denominations in descending order and recursively tries to use the maximum number of
// coins of each denomination before moving on to the next denomination. This approach helps to minimize the number of coins used and
// can lead to faster solutions for certain inputs.

class LC322CoinChangeSolutionDivisionApproach {
    int nCoins = Integer.MAX_VALUE;
    boolean coinsUpdated = false;

    private void coinChangeHelper(int[] coins, int amount, int start, int totalUsed) {
        if (coinsUpdated && totalUsed >= nCoins) {
            return;
        }

        if (amount == 0) {
            nCoins = totalUsed;
            coinsUpdated = true;
            return;
        }

        if (start >= coins.length) {
            return;
        }

        int coin = coins[start];
        int max = amount / coin;

        for (int i = max; i >= 0; i--) {
            int coinsUsed = i;

            coinChangeHelper(coins, amount - i * coin, start + 1, totalUsed + coinsUsed);
        }
    }

    public int coinChange(int[] coins, int amount) {
        coinChangeHelper(coins, amount, 0, 0);

        if (!coinsUpdated) {
            return -1;
        }
        return nCoins;
    }
}

class LC322CoinChangeDPSolution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

public class LC322CoinChange {
    public static void main(String[] args) {
        int[] coins = SystemUtils.takeIntArrayInput("Enter the coin denominations: ");
        int amount = SystemUtils.takeIntInput("Enter the amount: ");
        // System.out.println("Minimum coins needed: " + new
        // LC322CoinChangeSolution().coinChange(coins, amount));
        // System.out.println(
        //         "Minimum coins needed: " + new LC322CoinChangeSolutionDivisionApproach().coinChange(coins, amount));
        System.out.println(
                "Minimum coins needed: " + new LC322CoinChangeDPSolution().coinChange(coins, amount));
        
    }
}
