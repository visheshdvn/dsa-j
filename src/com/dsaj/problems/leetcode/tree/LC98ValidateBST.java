package com.dsaj.problems.leetcode.tree;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC98Solution {
    private boolean isValidBSTHelper(TreeNode root, Long lowerBound, Long upperBound) {
        if (root == null) {
            return true;
        }

        if(lowerBound != null && root.val <= lowerBound) {
            return false;
        }

        if(upperBound != null && root.val >= upperBound) {
            return false;
        }

        return isValidBSTHelper(root.left, lowerBound, (long) root.val) && isValidBSTHelper(root.right, (long) root.val, upperBound);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}

public class LC98ValidateBST {
    public static void main(String[] args) {
        LC98Solution solution = new LC98Solution();

        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();

        System.out.println("The entered tree is a valid BST? : " + solution.isValidBST(root));

    }
}
