package com.dsaj.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC145Solution {
    public void postorderTraversalHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;

        postorderTraversalHelper(root.left, list);
        postorderTraversalHelper(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderTraversalHelper(root, list);
        return list;
    }
}

public class LC145BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        LC144Solution solution = new LC144Solution();
        
        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();
        ArrayUtils.printList(solution.preorderTraversal(root));
    }
}
