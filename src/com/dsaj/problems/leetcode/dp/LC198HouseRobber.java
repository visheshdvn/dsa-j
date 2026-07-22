// ⭐
// Topics: #dp

package com.dsaj.problems.leetcode.dp;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC198HouseRobberSolution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int max1 = nums[0];
        int max2 = Math.max(max1, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int max = max1 + nums[i];

            max1 = max2;
            if(max > max2) {
                max2 = max;
            }
        }

        return Math.max(max1, max2);
    }
}

public class LC198HouseRobber {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter money values: ");

        System.out.println("Max amount = " + new LC198HouseRobberSolution().rob(nums));
    }
}
