package com.dsaj.concepts.dsa.trees.use;

import com.dsaj.concepts.dsa.trees.commons.BinaryTreeNode;
import com.dsaj.concepts.dsa.trees.commons.BinaryTreeOperations;
import com.dsaj.concepts.dsa.trees.commons.BinaryTreeUtils;

public class BinaryTreeUse {
    public static void main(String[] args) {
        // BinaryTreeNode<Integer> root = BinaryTreeUtils.buildIntegerTree();
        // BinaryTreeUtils.printTree(root);

        BinaryTreeNode<Integer> root = BinaryTreeUtils.buildLevelOrderIntegerTree();
        BinaryTreeUtils.printTreeInLevelOrder(root);

        System.out.println("Number of nodes in tree: " + BinaryTreeOperations.countNumberOfNodesRecursive(root));
        System.out.println("Number of nodes in tree: " + BinaryTreeOperations.countNumberOfNodesIterative(root));
    }
}
