package com.dsaj.concepts.dsa.trees.commons;

import com.dsaj.concepts.dsa.stackandqueue.commons.StackUsingLL;

public class BinaryTreeOperations {

    /**
     * Iterative pre-order traversal of a binary tree.
     * 
     * This method performs a pre-order traversal of a binary tree, printing the
     * data of each node
     * as it visits it. It uses a stack to keep track of the nodes that need to be
     * visited.
     * 
     * @param root the root of the binary tree
     */
    public static <T> void iterativePreOrderTraversal(BinaryTreeNode<T> root) {
        StackUsingLL<BinaryTreeNode<T>> stack = new StackUsingLL<>();

        BinaryTreeNode<T> node = root;

        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();
            System.out.println("visiting: " + node.getData());

            BinaryTreeNode<T> leftChild = node.leftChild();
            BinaryTreeNode<T> rightChild = node.rightChild();

            if (rightChild != null) {
                stack.push(rightChild);
            }
            if (leftChild != null) {
                stack.push(leftChild);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUtils.buildLevelOrderIntegerTree();

        iterativePreOrderTraversal(root);
    }
}
