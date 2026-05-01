package com.dsaj.problems.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.BinaryTreeUtils;
import com.dsaj.problems.leetcode.commons.BinaryTreeCommons.TreeNode;

/**
 * Intuition and Thought Process for Constructing Binary Tree:
 * 
 * 1. Role of Preorder: The preorder array serves as the "root finder." The very first 
 *    element of any given preorder segment is guaranteed to be the root of that subtree.
 * 
 * 2. Role of Inorder: The inorder array acts as the "divider." Once the root is identified, 
 *    its position in the inorder array naturally splits the remaining elements into left 
 *    and right subtrees.
 * 
 * 3. O(1) Lookup Optimization: A HashMap (inMap) pre-processes the inorder array, mapping 
 *    values to their indices. This eliminates the O(N) linear search overhead during 
 *    recursion, maintaining an optimal O(N) time complexity.
 * 
 * 4. Defining Inorder Boundaries: The root's index (indexOfRoot) perfectly divides the 
 *    inorder boundaries. The left inorder segment spans from the current start to just before 
 *    the root, while the right segment spans from just after the root to the current end.
 * 
 * 5. Calculating Left Preorder Boundaries: The left preorder segment always begins 
 *    immediately after the current root (pStart + 1). Its end boundary is calculated by 
 *    matching the exact length of the left inorder segment (leftInE - leftInS).
 * 
 * 6. Calculating Right Preorder Boundaries: The right preorder segment logically follows 
 *    the left one. It begins immediately after the left preorder segment terminates 
 *    (leftPreE + 1) and naturally continues to the end of the current preorder bound (pEnd).
 * 
 * 7. Recursive Construction: By explicitly calculating these specific start and end indices 
 *    for both arrays, the tree is built by passing these precise boundaries down to 
 *    recursively construct the left and right children.
 */

class LC105Solution {
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTreehelperNew(int[] pre, int[] in, int pStart, int pEnd, int iStart, int iEnd)
    {
        if (iStart > iEnd) {
            return null;
        }

        int rootData = pre[pStart];
        
        // int indexOfRoot = findIndex(in, rootData, iStart, iEnd);
        int indexOfRoot = inMap.get(rootData);
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