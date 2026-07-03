package com.dsaj.problems.leetcode.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

interface LC215KthLargestElementInArraySolution {
    int findKthLargest(int[] nums, int k);
}

class LC215KthLargestElementInArrayHeapSolution implements LC215KthLargestElementInArraySolution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num: nums) {
            maxHeap.offer(num);
        }

        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }

        return maxHeap.peek();
    }
}

class LC215KthLargestElementInArraySortingSolution implements LC215KthLargestElementInArraySolution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

class LC215KthLargestElementInArrayQuickSelectSolution implements LC215KthLargestElementInArraySolution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class LC215KthLargestElementInArray {
    public static void main(String[] args) {
        LC215KthLargestElementInArraySolution solution = new LC215KthLargestElementInArraySortingSolution();

        int[] nums = SystemUtils.takeIntArrayInput("Enter the array elements (space-separated): ");
        int k = SystemUtils.takeIntInput("Enter the value of k: ");

        System.out.println("kth largest = " + solution.findKthLargest(nums, k));
    }
}
