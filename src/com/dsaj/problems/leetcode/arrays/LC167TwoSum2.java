package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC167TwoSum2Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;

        while (i < j) {
            int sum = numbers[i] + numbers[j];

            if(sum == target) {
                return new int[] {i+1, j+1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }

        return new int[] {};
    }
}

public class LC167TwoSum2 {
    public static void main(String[] args) {
        LC167TwoSum2Solution solution = new LC167TwoSum2Solution();

        int[] nums = SystemUtils.takeIntArrayInput("Enter array values: ");
        int target = SystemUtils.takeIntInput("Enter target value: ");

        int[] ans = solution.twoSum(nums, target);
        ArrayUtils.printIntArray(ans);
    }
}
