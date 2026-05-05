package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.ArrayUtils;

class LC88SolutionNaive {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;

        // int temp = -1;
        // boolean valid = false;

        int[] copy = new int[m];
        for (int i = 0; i < m; i++) {
            copy[i] = nums1[i];
        }


        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if(copy[i] < nums2[j]) {
                nums1[k++] = copy[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }

        while (i < m) {
            nums1[k++] = copy[i++];
        }

        while (j < n) {
            nums1[k++] = nums2[j++];
        }
    }
}

class LC88Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;

        int idx = nums1.length-1, i = m-1, j = n-1;

        while (i >= 0 && j >= 0) {
            if(nums1[i] < nums2[j]) {
                nums1[idx--] = nums2[j--];
            } else {
                nums1[idx--] = nums1[i--];
            }
        }

        while (j >= 0) {
            nums1[idx--] = nums2[j--];
        }
    }
}

public class LC88MergeSortArray {
    public static void main(String[] args) {
        LC88Solution solution = new LC88Solution();        
        // int[] nums1 = SystemUtils.takeIntArrayInputOfSize("Enter first array: ", );
        // int[] nums2 = SystemUtils.takeIntArrayInput("Enter second array: ");

        int[] nums1 = {1, 2, 3, 0, 0, 0, 0};
        int[] nums2 = {-1, 2, 5 ,6};

        solution.merge(nums1, 3, nums2, nums2.length);

        ArrayUtils.printIntArray(nums1);
    }
}
