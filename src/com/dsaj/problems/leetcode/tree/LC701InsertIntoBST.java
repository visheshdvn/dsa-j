package com.dsaj.problems.leetcode.tree;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC701Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode cur = root;
        TreeNode prev = null;

        while (cur != null) {
            prev = cur;
            if (val < cur.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }

        if(prev.val > val) {
            prev.left = new TreeNode(val);
        } else {
            prev.right = new TreeNode(val);
        }

        return root;
    }
}

public class LC701InsertIntoBST {
    public static void main(String[] args) {
        LC701Solution solution = new LC701Solution();

        TreeNode root = BinaryTreeUtils.buildBinarySearchTree();
        int num = SystemUtils.takeIntInput("Enter value to insert in tree: ");

        root = solution.insertIntoBST(root, num);

        BinaryTreeUtils.printTreeInLevelOrder(root);
        BinaryTreeUtils.printInorderTraversalOfTree(root);
    }
}
