package com.dsaj.concepts.dsa.trees.use;

import com.dsaj.concepts.dsa.trees.commons.BinaryTreeNode;
import com.dsaj.concepts.dsa.trees.commons.BinaryTreeUtils;

public class BinarySearchTreeUse {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = BinaryTreeUtils.buildBinarySearchTree();
        BinaryTreeUtils.printTreeInLevelOrder(root);
    }
}
