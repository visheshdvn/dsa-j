package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC1929ConcatenationOfArraySolution {
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[2*nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i];
            result[i + nums.length] = nums[i];
        }

        return result;
    }
}

public class LC1929ConcatenationOfArray {
    public static void main(String[] args) {
        LC1929ConcatenationOfArraySolution solution = new LC1929ConcatenationOfArraySolution();

        int[] nums = SystemUtils.takeIntArrayInput("Enter the numbers: ");

        int[] ans = solution.getConcatenation(nums);

        System.out.print("Concatenated array: ");
        ArrayUtils.printIntArray(ans);
    }
}
