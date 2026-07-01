package com.dsaj.problems.leetcode.tree;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

interface LC1448GoodNodesInBinaryTreeSolution {
    int goodNodes(TreeNode root);
}

class LC1448GoodNodesInBinaryTreeSolutionSlower implements LC1448GoodNodesInBinaryTreeSolution {
    private int goodNodesHelper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        boolean thisIsGood = root.val >= max;

        int leftGood = goodNodesHelper(root.left, thisIsGood ? root.val : max);
        int rightGood = goodNodesHelper(root.right, thisIsGood ? root.val : max);

        return leftGood + rightGood + (thisIsGood ? 1 : 0);
    }

    public int goodNodes(TreeNode root) {
        return goodNodesHelper(root, root.val);
    }
}


/*
Solution is same as above. But the helper increments a global variable
instead of counting and returning one
 */
class LC1448GoodNodesInBinaryTreeSolutionOptimized implements LC1448GoodNodesInBinaryTreeSolution {
    int goodNodes = 0;

    private void goodNodesHelper(TreeNode root, int max) {
        if (root == null) {
            return;
        }

        if(root.val >= max) {
            goodNodes++;
            max = root.val;
        }

        goodNodesHelper(root.left, max);
        goodNodesHelper(root.right, max);
    }

    public int goodNodes(TreeNode root) {
        goodNodes = 0;
        goodNodesHelper(root, root.val);
        return goodNodes;
    }
}

public class LC1448GoodNodesInBinaryTree {
    public static void main(String[] args) {
        LC1448GoodNodesInBinaryTreeSolution solution = new LC1448GoodNodesInBinaryTreeSolutionOptimized();

        TreeNode root = BinaryTreeUtils.buildLevelOrderIntegerTree();
        System.out.println("No of good nodes: " + solution.goodNodes(root));
    }
}
