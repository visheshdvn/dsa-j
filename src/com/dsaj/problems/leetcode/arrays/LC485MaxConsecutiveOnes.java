package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC485MaxConsecutiveOnesSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
        }

        return maxCount;
    }
}

public class LC485MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter the array of 0s and 1s: ");

        System.out.println("Maximum number of consecutive 1s in the array: "
                + new LC485MaxConsecutiveOnesSolution().findMaxConsecutiveOnes(nums));
    }
}