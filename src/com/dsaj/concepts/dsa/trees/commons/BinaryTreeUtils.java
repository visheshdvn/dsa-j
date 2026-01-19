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

    /**
     * Inserts a node with the given data into a binary search tree.
     * If the tree is empty, the node is inserted as the root.
     * If the data is less than or equal to the node's data, the node is inserted
     * into the left subtree. Otherwise, the node is inserted into the right subtree.
     * 
     * @param root the root of the binary search tree
     * @param data the data to be inserted
     * @return the root of the modified binary search tree
     */
    public static BinaryTreeNode<Integer> insertInBST(BinaryTreeNode<Integer> root, Integer data) {
        if(root == null) {
            root = new BinaryTreeNode<>(data);
            return root;
        }

        BinaryTreeNode<Integer> node = root;
        while (true) {
            if (data <= node.getData()) {
                if(node.leftChild() == null) {
                    node.setLeftChild(new BinaryTreeNode<Integer>(data));
                    break;
                } else {
                    node = node.leftChild();
                }
            } else {
                if(node.rightChild() == null) {
                    node.setRightChild(new BinaryTreeNode<Integer>(data));
                    break;
                } else {
                    node = node.rightChild();
                }
            }
        }

        return root;
    }

    /**
     * Builds a binary search tree from user input.
     * The user is prompted to enter integers one by one, and each integer is inserted into the binary search tree.
     * If the user enters -1, the loop is terminated.
     * 
     * @return the root of the binary search tree
     */
    public static BinaryTreeNode<Integer> buildBinarySearchTree() {
        BinaryTreeNode<Integer> root = null;

        while (true) {
            Integer n = SystemUtils.takeIntInput("Enter number to insert: ");

            if(n == -1) {
                break;
            }

            root = insertInBST(root, n);
        }

        return root;
    }

    /**
     * Prints the binary tree recursively in a depth-first manner.
     * For each node, the node's data is printed, followed by the data of its left child and then its right child.
     * If the node is null, nothing is printed.
     *
     * @param root the root of the binary tree
     * @deprecated
     */
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

    /**
     * Returns the number of nodes in the binary tree.
     * 
     * The method uses a recursive approach to count the number of nodes in the binary tree.
     * 
     * @param root the root of the binary tree
     * @return the number of nodes in the binary tree
     * @deprecated because this method use more RAM than iterative one
     */
    public static <T> Integer countNumberOfNodesRecursive(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNumberOfNodesRecursive(root.leftChild()) + countNumberOfNodesRecursive(root.rightChild());
    }

    /**
     * Returns the number of nodes in the binary tree.
     * 
     * The method uses an iterative approach to count the number of nodes in the binary tree.
     * 
     * @param root the root of the binary tree
     * @return the number of nodes in the binary tree
     */
    public static <T> Integer countNumberOfNodesIterative(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        QueueUsingLL<BinaryTreeNode<T>> queue = new QueueUsingLL<>();
        queue.enqueue(root);

        Integer count = 0;
        while (!queue.isEmpty()) {
            count++;

            BinaryTreeNode<T> currentNode = queue.dequeue();
            if (currentNode.leftChild() != null) {
                queue.enqueue(currentNode.leftChild());
            }

            if (currentNode.rightChild() != null) {
                queue.enqueue(currentNode.rightChild());
            }
        }

        return count;
    }
}
