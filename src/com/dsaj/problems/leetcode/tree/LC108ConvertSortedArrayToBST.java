package com.dsaj.problems.leetcode.tree;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC108Solution {
    public TreeNode sortedArrayToBSTHelper(int[] nums, int min, int max) {
        if (min > max) {
            return null;
        }

        int mid = (min + max + 1) / 2;

        TreeNode leftChild = sortedArrayToBSTHelper(nums, min, mid-1);
        TreeNode rightChild = sortedArrayToBSTHelper(nums, mid+1, max);

        return new TreeNode(nums[mid], leftChild, rightChild);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }
}

public class LC108ConvertSortedArrayToBST {
    public static void main(String[] args) {
        LC108Solution solution = new LC108Solution();

        int[] array = SystemUtils.takeIntArrayInput("Enter array values: ");

        TreeNode root = solution.sortedArrayToBST(array);

        BinaryTreeUtils.printTreeInLevelOrder(root);
    }
}
