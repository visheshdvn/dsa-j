package com.dsaj.problems.leetcode.commons;

import com.dsaj.concepts.dsa.stackandqueue.commons.QueueUsingLL;
import com.dsaj.concepts.dsa.utils.SystemUtils;

public class BinaryTreeCommons {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class BinaryTreeUtils {
        /**
         * Builds a binary tree level by level, taking user input for each node's data.
         * The user is prompted to enter the data for each node, and if the user enters
         * -1,
         * the node is considered to be null.
         *
         * @return the root of the binary tree
         */
        public static TreeNode buildLevelOrderIntegerTree() {
            QueueUsingLL<TreeNode> queue = new QueueUsingLL<>();

            int val = SystemUtils.takeIntInput("Enter node data: ");
            if (val == -1) {
                return null;
            }

            TreeNode root = new TreeNode(val);
            queue.enqueue(root);

            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.dequeue();

                int leftChildData = SystemUtils
                        .takeIntInput("Enter left child data for node " + currentNode.val + " : ");
                if (leftChildData != -1) {
                    TreeNode leftChild = new TreeNode(leftChildData);
                    currentNode.left = leftChild;
                    queue.enqueue(leftChild);
                }

                int rightChildData = SystemUtils
                        .takeIntInput("Enter right child data for node " + currentNode.val + " : ");
                if (rightChildData != -1) {
                    TreeNode rightChild = new TreeNode(rightChildData);
                    currentNode.right = rightChild;
                    queue.enqueue(rightChild);
                }
            }

            return root;
        }

        /**
         * Prints the binary tree in level order.
         * 
         * @param root the root of the binary tree
         */
        public static void printTreeInLevelOrder(TreeNode root) {
            if (root == null) {
                System.out.println("Tree is empty.");
                return;
            }

            QueueUsingLL<TreeNode> queue = new QueueUsingLL<>();
            queue.enqueue(root);

            while (!queue.isEmpty()) {
                TreeNode currentNode = queue.dequeue();
                TreeNode leftChild = currentNode.left;
                TreeNode rightChild = currentNode.right;

                String leftData = leftChild != null ? String.valueOf(leftChild.val) : "null";
                String rightData = rightChild != null ? String.valueOf(rightChild.val) : "null";

                System.out.println(currentNode.val + " | L " + leftData + ", R " + rightData);

                if (leftChild != null) {
                    queue.enqueue(leftChild);
                }

                if (rightChild != null) {
                    queue.enqueue(rightChild);
                }
            }
        }
    }
}
