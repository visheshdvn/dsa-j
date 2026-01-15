package com.dsaj.problems.leetcode.tree;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC104Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

public class LC104MaxDepthOfBinaryTree {
    public static void main(String[] args) {
        LC104Solution solution = new LC104Solution();

        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();

        System.out.println("Depth = " + solution.maxDepth(root));
    }
}
