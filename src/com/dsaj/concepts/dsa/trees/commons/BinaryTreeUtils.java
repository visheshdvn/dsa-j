package com.dsaj.concepts.dsa.trees.commons;

import com.dsaj.concepts.dsa.stackandqueue.commons.QueueUsingLL;
import com.dsaj.concepts.dsa.utils.SystemUtils;

public class BinaryTreeUtils<T> {

    /**
     * Builds a binary tree using a recursive approach, taking user input for each
     * node's data.
     * The user is prompted to enter the data for each node, and if the user enters
     * -1, the node is considered to be null.
     * 
     * @return the root of the binary tree
     */
    public static BinaryTreeNode<Integer> buildIntegerTree() {
        Integer n = SystemUtils.takeIntInput("Enter value for node (-1 for null): ");

        if (n == -1) {
            return null;
        }

        BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(n);

        node.setLeftChild(buildIntegerTree());
        node.setRightChild(buildIntegerTree());

        return node;
    }

    /**
     * Builds a binary tree level by level, taking user input for each node's data.
     * The user is prompted to enter the data for each node, and if the user enters
     * -1,
     * the node is considered to be null.
     *
     * @return the root of the binary tree
     */
    public static BinaryTreeNode<Integer> buildLevelOrderIntegerTree() {
        QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
        Integer val = SystemUtils.takeIntInput("Enter node data: ");
        if (val == -1) {
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(val);
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> currentNode = queue.dequeue();

            Integer leftChildData = SystemUtils
                    .takeIntInput("Enter left child data for node " + currentNode.getData() + " : ");
            if (leftChildData != -1) {
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(leftChildData);
                currentNode.setLeftChild(leftChild);
                queue.enqueue(leftChild);
            }

            Integer rightChildData = SystemUtils
                    .takeIntInput("Enter right child data for node " + currentNode.getData() + " : ");
            if (rightChildData != -1) {
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(rightChildData);
                currentNode.setRightChild(rightChild);
                queue.enqueue(rightChild);
            }
        }

        return root;
    }

    public static <T> void printTree(BinaryTreeNode<T> root) {
        if (root == null) {
            return;
        }

        T leftData = root.leftChild() != null ? root.leftChild().getData() : null;
        T rightData = root.rightChild() != null ? root.rightChild().getData() : null;
        System.out.println(root.getData() + " | L " + leftData + ", R " + rightData);
        printTree(root.leftChild());
        printTree(root.rightChild());
    }

    /**
     * Prints the binary tree in level order.
     * 
     * @param root the root of the binary tree
     */
    public static <T> void printTreeInLevelOrder(BinaryTreeNode<T> root) {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        QueueUsingLL<BinaryTreeNode<T>> queue = new QueueUsingLL<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> currentNode = queue.dequeue();
            BinaryTreeNode<T> leftChild = currentNode.leftChild();
            BinaryTreeNode<T> rightChild = currentNode.rightChild();

            T leftData = leftChild != null ? leftChild.getData() : null;
            T rightData = rightChild != null ? rightChild.getData() : null;

            System.out.println(currentNode.getData() + " | L " + leftData + ", R " + rightData);

            if (leftChild != null) {
                queue.enqueue(leftChild);
            }

            if (rightChild != null) {
                queue.enqueue(rightChild);
            }
        }
    }
}
