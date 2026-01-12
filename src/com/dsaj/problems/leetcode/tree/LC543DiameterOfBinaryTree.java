package com.dsaj.problems.leetcode.tree;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC543SolutionNaive {
    public int[] diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return new int[] { -1, -1 };
        }

        int[] leftData = diameterOfBinaryTreeHelper(root.left);
        int[] rightData = diameterOfBinaryTreeHelper(root.right);

        return new int[] {
                Math.max(Math.max(leftData[0], rightData[0]), leftData[1] + rightData[1] + 2),
                Math.max(leftData[1], rightData[1]) + 1
        };
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = diameterOfBinaryTreeHelper(root);
        return Math.max(0, ans[0]);
    }
}

class LC543Solution {

    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left, diameter);
        int rh = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], lh + rh);

        return 1 + Math.max(lh, rh);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }
}

public class LC543DiameterOfBinaryTree {
    public static void main(String[] args) {
        LC543Solution solution = new LC543Solution();

        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();
        // BinaryTreeUtils.printTreeInLevelOrder(root);

        int answer = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter = " + answer);
    }
}
