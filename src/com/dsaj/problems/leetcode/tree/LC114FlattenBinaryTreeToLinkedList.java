package com.dsaj.problems.leetcode.tree;

import java.util.Stack;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC114SolutionNaive {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;

        stack.push(node);

        TreeNode lastNode = new TreeNode();

        while (!stack.isEmpty()) {
            node = stack.pop();

            TreeNode leftChild = node.left;
            TreeNode rightChild = node.right;

            if (rightChild != null) {
                stack.push(rightChild);
            }
            if (leftChild != null) {
                stack.push(leftChild);
            }

            node.left = null;
            lastNode.right = node;
            lastNode = lastNode.right;
        }
    }
}

class LC114Solution {
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}

public class LC114FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        LC114Solution solution = new LC114Solution();

        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();

        solution.flatten(root);

        BinaryTreeUtils.printTreeInLevelOrder(root);
    }
}
