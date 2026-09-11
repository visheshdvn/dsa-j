package com.dsaj.problems.leetcode.slidingwindow;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC1004MaxConsecutiveOnesSolution3Solution {
    public int longestOnes(int[] nums, int k) {
        int rear = 0, front = 0;
        int zeroCount = 0;
        int maxConsecutives = 0;

        while (front < nums.length) {
            if (nums[front] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[rear] == 0) {
                    zeroCount--;
                }
                rear++;
            }

            maxConsecutives = Math.max(maxConsecutives, front - rear + 1);
            front++;

        }
        return maxConsecutives;
    }
}

public class LC1004MaxConsecutiveOnesSolution3 {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter the array of 0s and 1s: ");

        int k = SystemUtils.takeIntInput("Enter the maximum number of 0s that can be flipped: ");

        System.out.println("Maximum number of consecutive 1s in the array: "
                + new LC1004MaxConsecutiveOnesSolution3Solution().longestOnes(nums, k));
    }
}