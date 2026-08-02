package com.dsaj.problems.leetcode.greedy;

import com.dsaj.concepts.dsa.utils.SystemUtils;

/**
 * Brute-force recursive solution that tries every possible jump path.
 * Time complexity: O(2^n) in the worst case, space complexity: O(n) due to recursion depth.
 * This is the worst solution among the three.
 */
class LC53JumpGameBrutoForceSolution {
    boolean canReach = false;

    private void backtrack(int[] nums, int start) {
        if (start >= nums.length || canReach) {
            return;
        }

        if (start == nums.length - 1) {
            canReach = true;
            return;
        }

        int steps = nums[start];
        for (int j = 1; j <= steps; j++) {
            backtrack(nums, start + j);
        }
    }

    public boolean canJump(int[] nums) {
        backtrack(nums, 0);
        return canReach;
    }
}

/**
 * Dynamic programming solution that marks reachable indices from previously reachable positions.
 * Time complexity: O(n^2), space complexity: O(n).
 * This is better than brute force but worse than greedy.
 */
class LC53JumpGameDPSolution {

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && i - j <= nums[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[dp.length - 1];
    }
}

/**
 * Greedy solution that works backward from the last index to find the earliest valid position.
 * Time complexity: O(n), space complexity: O(1).
 * This is the best solution among the three.
 */
class LC53JumpGameGreedySolution {

    public boolean canJump(int[] nums) {
        int finalPosition = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (finalPosition - i <= nums[i]) {
                finalPosition = i;
            }
        }

        return finalPosition == 0;
    }
}

/**
 * Best to worst: LC53JumpGameGreedySolution, LC53JumpGameDPSolution, LC53JumpGameBrutoForceSolution.
 */
public class LC53JumpGame {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter jump values: ");

        System.out.println("can reach last index: " + new LC53JumpGameDPSolution().canJump(nums));
    }
}
