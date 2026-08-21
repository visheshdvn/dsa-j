package com.dsaj.problems.leetcode.greedy;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC45JumpGame2Solution {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        jumps[0] = 0;

        for (int i = 1; i < jumps.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < jumps.length - 1; i++) {
            int num = nums[i];

            for (int jump = 1; jump <= num && i + jump < nums.length; jump++) {
                jumps[i + jump] = Math.min(jumps[i] + 1, jumps[i + jump]);
            }
        }

        return jumps[jumps.length - 1];
    }
}

class LC45JumpGame2GreedySolution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}

public class LC45JumpGame2 {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter jump values: ");

        System.out.println("minimum jumps to reach last index: " + new LC45JumpGame2Solution().jump(nums));
    }
}
