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
         * Inserts a node with the given data into a binary search tree.
         * If the tree is empty, the node is inserted as the root.
         * If the data is less than or equal to the node's data, the node is inserted
         * into the left subtree. Otherwise, the node is inserted into the right
         * subtree.
         * 
         * @param root the root of the binary search tree
         * @param data the data to be inserted
         * @return the root of the modified binary search tree
         */

        private static TreeNode insertInBST(TreeNode root, Integer data) {
            if (root == null) {
                root = new TreeNode(data);
                return root;
            }

            TreeNode node = root;
            while (true) {
                if (data <= node.val) {
                    if (node.left == null) {
                        node.left = new TreeNode(data);
                        break;
                    } else {
                        node = node.left;
                    }
                } else {
                    if (node.right == null) {
                        node.right = new TreeNode(data);
                        break;
                    } else {
                        node = node.right;
                    }
                }
            }

            return root;
        }

        /**
         * Builds a binary search tree from user input.
         * The user is prompted to enter integers one by one, and each integer is
         * inserted into the binary search tree.
         * If the user enters -1, the loop is terminated.
         * 
         * @return the root of the binary search tree
         */
        public static TreeNode buildBinarySearchTree() {
            TreeNode root = null;

            while (true) {
                Integer n = SystemUtils.takeIntInput("Enter number to insert: ");

                if (n == -1) {
                    break;
                }

                root = insertInBST(root, n);
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
