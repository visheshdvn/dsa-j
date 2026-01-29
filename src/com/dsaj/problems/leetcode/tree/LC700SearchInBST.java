package com.dsaj.problems.leetcode.tree;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC700SolutionRecursive {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        TreeNode left = searchBST(root.left, val);

        if (left != null) {
            return left;
        }

        return searchBST(root.right, val);
    }
}

class LC700Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else if(val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}

public class LC700SearchInBST {
    public static void main(String[] args) {
        LC700Solution solution = new LC700Solution();

        TreeNode root = BinaryTreeUtils.buildBinarySearchTree();
        int num = SystemUtils.takeIntInput("Enter value to search: ");

        TreeNode node = solution.searchBST(root, num);

        BinaryTreeUtils.printTreeInLevelOrder(node);
    }
}
