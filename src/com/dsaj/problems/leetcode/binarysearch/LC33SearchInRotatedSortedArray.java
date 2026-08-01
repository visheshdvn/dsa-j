package com.dsaj.problems.leetcode.binarysearch;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC33SearchInRotatedSortedArraySolution {
    public int search(int[] nums, int target) {
        int front = nums.length - 1;
        int rear = 0;

        while (rear <= front) {
            int middle = rear + (front - rear) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[rear] <= nums[middle]) {
                if (nums[rear] <= target && target < nums[middle]) {
                    front = middle - 1;
                } else {
                    rear = middle + 1;
                }
            } else {
                if (nums[middle] < target && target < nums[rear]) {
                    rear = middle + 1;
                } else {
                    front = middle - 1;
                }
            }
        }

        return -1;
    }
}

public class LC33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter array elements: ");
        int target = SystemUtils.takeIntInput("Enter the target number: ");

        System.out.println("Target's index: " + new LC33SearchInRotatedSortedArraySolution().search(nums, target));
    }
}

// 4 5 6 7 0 1 2