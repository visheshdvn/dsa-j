package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC153Solution {
    public int findMin(int[] nums) {
        int front = nums.length-1;
        int rear = 0;

        int minElement = Integer.MAX_VALUE;

        while (front >= rear) {
            int middle = (front + rear + 1) / 2;

            if (nums[middle] <= nums[front]) {
                minElement = Math.min(minElement, nums[middle]);
                front = middle-1;
            } else if(nums[middle] > nums[rear]) {
                minElement = Math.min(minElement, nums[rear]);
                rear = middle+1;
            }
        }

        return minElement;
    }
}

public class LC153FindMinInRotatedSortedArray {

    public static void main(String[] args) {
        LC153Solution solution = new LC153Solution();

        int[] array = SystemUtils.takeIntArrayInput("Enter array values: ");

        System.out.println("Min element: " + solution.findMin(array));
    }
}