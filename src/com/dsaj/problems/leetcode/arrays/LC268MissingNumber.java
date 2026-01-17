package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC268Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;

        int arraySum = 0;

        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
        }

        return expectedSum - arraySum;
    }
}

public class LC268MissingNumber {
    public static void main(String[] args) {
        LC268Solution solution = new LC268Solution();

        int[] array = SystemUtils.takeIntArrayInput("Enter array values: ");

        System.out.println("Missing number: " + solution.missingNumber(array));
    }
}
