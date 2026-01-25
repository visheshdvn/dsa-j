package com.dsaj.problems.leetcode.tree;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC938SolutionNaive {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }

        int leftSum = rangeSumBST(root.left, low, high);
        int rightSum = rangeSumBST(root.right, low, high);

        if (low <= root.val && root.val <= high) {
            return root.val + leftSum + rightSum;
        } else {
            return leftSum + rightSum;
        }
    }
}

class LC938Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }

        int leftSum = 0;
        if(root.val > low) {
            leftSum = rangeSumBST(root.left, low, high);
        }

        int rightSum = 0;
        if(root.val < high) {
            rightSum = rangeSumBST(root.right, low, high);
        }

        if (low <= root.val && root.val <= high) {
            return root.val + leftSum + rightSum;
        } else {
            return leftSum + rightSum;
        }
    }
}

public class LC938RangeSumofBST {
    public static void main(String[] args) {
        LC938Solution solution = new LC938Solution();

        TreeNode root = BinaryTreeUtils.buildBinarySearchTree();
        int low = SystemUtils.takeIntInput("Enter low value: ");
        int high = SystemUtils.takeIntInput("Enter high value: ");
        BinaryTreeUtils.printTreeInLevelOrder(root);

        System.out.println("Sum of Range = " + solution.rangeSumBST(root, low, high));
    }
}
