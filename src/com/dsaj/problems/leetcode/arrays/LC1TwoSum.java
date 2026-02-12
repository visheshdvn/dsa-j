package com.dsaj.problems.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC1TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] pair = {};

        for (int i = 0; i < nums.length; i++) {
            int expected = target - nums[i];
            if (map.getOrDefault(expected, -1) == -1) {
                map.put(nums[i], i);
            } else {
                pair = new int[] { i, map.get(expected) };
                break;
            }
        }

        return pair;
    }
}

public class LC1TwoSum {
    public static void main(String[] args) {
        LC1TwoSumSolution solution = new LC1TwoSumSolution();

        int[] nums = SystemUtils.takeIntArrayInput("Enter array values: ");
        int target = SystemUtils.takeIntInput("Enter target value: ");

        int[] ans = solution.twoSum(nums, target);

        ArrayUtils.printIntArray(ans);
    }
}
