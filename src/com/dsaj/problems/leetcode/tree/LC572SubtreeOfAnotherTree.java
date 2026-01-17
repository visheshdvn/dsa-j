package com.dsaj.problems.leetcode.tree;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC572Solution {
    public boolean isSubTreeHelper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root != null && subRoot == null || subRoot != null && root == null) {
            return false;
        }

        return (root.val == subRoot.val)
                && isSubTreeHelper(root.left, subRoot.left)
                && isSubTreeHelper(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val) {
            boolean isSubtree = isSubTreeHelper(root, subRoot);
            if (isSubtree) {
                return true;
            }
        }

        // boolean isLeftSubtree = isSubtree(root.left, subRoot);
        // if (isLeftSubtree) {
        // return true;
        // }

        // return isSubtree(root.right, subRoot);

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}

public class LC572SubtreeOfAnotherTree {
    public static void main(String[] args) {
        LC572Solution solution = new LC572Solution();

        TreeNode root1 = BinaryTreeUtils.buildLevelOrderIntegerTree();
        TreeNode subRoot = BinaryTreeUtils.buildLevelOrderIntegerTree();

        System.out.println("Is sub-tree: " + solution.isSubtree(root1, subRoot));
    }
}
