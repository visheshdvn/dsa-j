package com.dsaj.problems.leetcode.dp;

import com.dsaj.concepts.dsa.utils.SystemUtils;

interface LC70ClimbingStairsSolution {
    int climbStairs(int n);
}

/**
 * Top-down dynamic programming solution using memoization.
 * <p>
 * Recursively computes the number of ways to climb the stairs and caches
 * intermediate results in an array to avoid repeated work.
 * </p>
 */
class LC70ClimbingStairsMemoizationSolution implements LC70ClimbingStairsSolution {
    private int climbStairsHelper(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }

    public int climbStairs(int n) {
        int[] memo = new int[Math.max(2, n + 1)];
        memo[0] = 1;
        memo[1] = 1;

        return climbStairsHelper(n, memo);
    }
}


/**
 * Bottom-up dynamic programming solution using tabulation.
 * <p>
 * Builds a DP table from the base cases up to {@code n}, computing each value iteratively.
 * </p>
 */
class LC70ClimbingStairsTabulationSolution implements LC70ClimbingStairsSolution {
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }

        int[] ways = new int[n + 1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];
    }
}

/**
 * Bottom-up dynamic programming solution with O(1) extra space.
 * <p>
 * Only stores the last two computed results because the state transition
 * only depends on the previous two stair counts.
 * </p>
 */
class LC70ClimbingStairsTabulationMemoryOptimizedSolution implements LC70ClimbingStairsSolution {
    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        int first=1, second = 1, front = 0;
        for(int i=2; i<=n; i++)
        {
            front=first+second;
            first=second;
            second=front;
        }
        return front;
    }
}

public class LC70ClimbingStairs {
    public static void main(String[] args) {
        LC70ClimbingStairsSolution solution1 = new LC70ClimbingStairsMemoizationSolution();

        long startTime = System.currentTimeMillis();
        int n = SystemUtils.takeIntInput("Enter the number of stairs: ");
        System.out.println("Number of ways to climb " + n + " stairs: " + solution1.climbStairs(n));
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        LC70ClimbingStairsSolution solution2 = new LC70ClimbingStairsTabulationSolution();
        startTime = System.currentTimeMillis();
        System.out.println("Number of ways to climb " + n + " stairs: " + solution2.climbStairs(n));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");

        LC70ClimbingStairsSolution solution3 = new LC70ClimbingStairsTabulationMemoryOptimizedSolution();
        startTime = System.currentTimeMillis();
        System.out.println("Number of ways to climb " + n + " stairs: " + solution3.climbStairs(n));
        endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) + " ms");
    }
}