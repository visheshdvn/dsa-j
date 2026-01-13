package com.dsaj.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC94Solution {
    public void inorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorderTraversalHelper(root.left, list);
        list.add(root.val);
        inorderTraversalHelper(root.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversalHelper(root, list);
        return list;
    }
}

public class LC94BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        LC94Solution solution = new LC94Solution();
        
        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();
        ArrayUtils.printList(solution.inorderTraversal(root));

        // BinaryTreeUtils.printTreeInLevelOrder(root);

    }
}