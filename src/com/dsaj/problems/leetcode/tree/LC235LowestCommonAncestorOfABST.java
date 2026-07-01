package com.dsaj.problems.leetcode.tree;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC235Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}

public class LC235LowestCommonAncestorOfABST {
    public static void main(String[] args) {
        LC235Solution solution = new LC235Solution();

        TreeNode root = BinaryTreeUtils.buildBinarySearchTree();
        int p = SystemUtils.takeIntInput("Enter first value: ");
        int q = SystemUtils.takeIntInput("Enter second value: ");

        TreeNode lca = solution.lowestCommonAncestor(root, new TreeNode(p), new TreeNode(q));

        BinaryTreeUtils.printTreeInLevelOrder(lca);
    }
}
