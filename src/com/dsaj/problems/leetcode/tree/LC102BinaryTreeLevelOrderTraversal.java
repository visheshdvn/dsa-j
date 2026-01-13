package com.dsaj.problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC102Solution {

    public List<Integer> getOrDefault(List<List<Integer>> list, int index) {
        if (index < list.size()) {
            return list.get(index);
        } else {
            return null;
        }
    }

    public void levelOrderHelper(TreeNode root, List<List<Integer>> list, int index) {
        if (root == null)
            return;

        List<Integer> l = getOrDefault(list, index);
        if (l != null) {
            l.add(root.val);
            list.set(index, l);
        } else {
            List<Integer> newList = new ArrayList<>();
            newList.add(root.val);
            list.add(newList);
        }

        levelOrderHelper(root.left, list, index+1);
        levelOrderHelper(root.right, list, index+1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderHelper(root, list, 0);
        return list;
    }
}

public class LC102BinaryTreeLevelOrderTraversal {

    private static void printList(List<List<Integer>> list) {
        System.out.println(list.toString());
    }

    public static void main(String[] args) {
        LC102Solution solution = new LC102Solution();

        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();

        printList(solution.levelOrder(root));
    }
}
