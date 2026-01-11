package com.dsaj.concepts.dsa.trees.commons;

import com.dsaj.concepts.dsa.stackandqueue.commons.QueueUsingLL;

public class BinaryTreeOperations<T> {
    public static <T> Integer countNumberOfNodesRecursive(BinaryTreeNode<T> root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNumberOfNodesRecursive(root.leftChild()) + countNumberOfNodesRecursive(root.rightChild());
    }

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
