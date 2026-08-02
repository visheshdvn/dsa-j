// Kadane's Algorithm
// ⭐

package com.dsaj.problems.leetcode.greedy;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC53MaximumSubarraySolution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }
}

public class LC53MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter array values: ");

        System.out.println("Max sum: " + new LC53MaximumSubarraySolution().maxSubArray(nums));
    }
}
