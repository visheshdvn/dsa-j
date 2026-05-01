package com.dsaj.problems.leetcode.tree;

import java.util.stream.IntStream;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

class LC105Solution {
    public int findIndex(int[] arr, int elem, int low, int high)
    {
        int idx = IntStream.range(low, high+1)
            .filter(i -> elem == arr[i])
            .findFirst()
            .orElse(-1);
        
        return idx;
    }

    public TreeNode buildTreehelper(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd)
    {
        if(iStart == iEnd) {
            return new TreeNode(in[iStart]);
        }

        int indexOfRoot = findIndex(in, pre[pStart], iStart, iEnd);
        System.out.println("index of " + pre[pStart] + " : " + indexOfRoot);


        TreeNode leftChild = null, rightChild = null;
        if(indexOfRoot != iStart) {
            leftChild = buildTreehelper(pre, in, pStart+1, pEnd+indexOfRoot, iStart, Math.max(iStart, indexOfRoot-1));
        }

        if(indexOfRoot != iEnd) {
            rightChild = buildTreehelper(pre, in, pStart+indexOfRoot+1, pEnd, Math.min(indexOfRoot+1, iEnd), iEnd);
        }


        return new TreeNode(pre[0], leftChild, rightChild);
    }

    public TreeNode buildTreehelperNew(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd)
    {
        if (iStart > iEnd) {
            return null;
        }

        int rootData = pre[pStart];
        
        int indexOfRoot = findIndex(in, rootData, iStart, iEnd);
        if(indexOfRoot == -1) {
            return null;
        }

        int leftInS = iStart;
        int leftInE = indexOfRoot -1;
        int leftPreS = pStart+1;
        int leftPreE = leftPreS + leftInE - leftInS;
        int rightInS = indexOfRoot+1;
        int rightInE = iEnd;
        int rightPreS = leftPreE+1;
        int rightPreE = pEnd;

        TreeNode leftChild = null, rightChild = null;
        leftChild = buildTreehelperNew(pre, in, leftPreS, leftPreE, leftInS, leftInE);
        rightChild = buildTreehelperNew(pre, in, rightPreS, rightPreE, rightInS, rightInE);

        return new TreeNode(rootData, leftChild, rightChild);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreehelperNew(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
}


public class LC105ConstructBTFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        LC105Solution solution = new LC105Solution();

        // int[] preorder = SystemUtils.takeIntArrayInput("Enter preorder traversal list: ");
        // int[] inorder = SystemUtils.takeIntArrayInput("Enter inorder traversal list: ");

        int[] preorder = {1, 2, 4, 5, 3, 7};
        int[] inorder = {4, 2, 5, 1, 3, 7};

        TreeNode root = solution.buildTree(preorder, inorder);

        BinaryTreeUtils.printTreeInLevelOrder(root);
    }   
}