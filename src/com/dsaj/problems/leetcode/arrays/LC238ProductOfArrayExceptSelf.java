package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC238ProductOfArrayExceptSelfSolutionNaive {

    public int computeRightProduct(int[] array, int index) {
        int product = 1;

        for (int i = index + 1; i < array.length; i++) {
            product *= array[i];
        }

        return product;
    }

    public int getValueAtIndex(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            return 1;
        }
        return array[index];
    }

    public int[] productExceptSelf(int[] nums) {
        int leftProduct = 1;
        int rightProduct = computeRightProduct(nums, 0);

        int[] result = new int[nums.length];

        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                rightProduct = computeRightProduct(nums, i);
            }

            leftProduct *= getValueAtIndex(nums, i - 1);

            result[i] = leftProduct * rightProduct;

            if (getValueAtIndex(nums, i + 1) != 0) {
                rightProduct /= getValueAtIndex(nums, i + 1);
            }

            i++;
        }

        return result;
    }
}

class LC238ProductOfArrayExceptSelfSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        int prefixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int postfixProduct = 1;
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] *= postfixProduct;
            postfixProduct *= nums[i];
        }

        return result;
    }
}

public class LC238ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        LC238ProductOfArrayExceptSelfSolution solution = new LC238ProductOfArrayExceptSelfSolution();

        int[] array = SystemUtils.takeIntArrayInput("Enter Array Elements: ");

        int[] products = solution.productExceptSelf(array);

        ArrayUtils.printIntArray(products);
    }
}
