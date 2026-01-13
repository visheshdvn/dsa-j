package com.dsaj.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC144Solution {
    public void preorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        preorderTraversalHelper(root.left, list);
        preorderTraversalHelper(root.right, list);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversalHelper(root, list);
        return list;
    }
}

public class LC144BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        LC144Solution solution = new LC144Solution();
        
        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();
        ArrayUtils.printList(solution.preorderTraversal(root));
    }
}
