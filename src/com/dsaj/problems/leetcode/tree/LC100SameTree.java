package com.dsaj.problems.leetcode.tree;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC100Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.left, q.left);
    }
}

public class LC100SameTree {
    public static void main(String[] args) {
        LC100Solution solution = new LC100Solution();

        TreeNode root1 = BinaryTreeUtils.buildLevelOrderIntegerTree();
        TreeNode root2 = BinaryTreeUtils.buildLevelOrderIntegerTree();

        System.out.println("Is sub-tree: " + solution.isSameTree(root1, root2));
    }
}
