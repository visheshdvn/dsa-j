package com.dsaj.problems.leetcode.tree;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC230KthSmallestElementInBSTSolution {
    int ind;
    public int kthSmallest(TreeNode root, int k) {
        int[] result = new int[k];
        ind = k-1;
        inorder(root, result);
        return result[0];
    }

    private void inorder(TreeNode root, int[] arr) {
        if (root == null || ind < 0) {
            return;
        }

        inorder(root.left, arr);
        if (ind < 0) {
            return;
        }

        arr[ind] = root.val;
        ind -=1;
        inorder(root.right, arr);
    }
}

public class LC230KthSmallestElementInBST {
    public static void main(String[] args) {
        LC230KthSmallestElementInBSTSolution solution = new LC230KthSmallestElementInBSTSolution();

        TreeNode head = BinaryTreeUtils.buildBinarySearchTree();
        int k = SystemUtils.takeIntInput("Enter value of k: ");

        System.out.println("kth smallest element: " + solution.kthSmallest(head, k));
    }
}
