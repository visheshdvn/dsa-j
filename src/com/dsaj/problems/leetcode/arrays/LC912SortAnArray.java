package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

/*
 * Sort an array using merge sort algorithm.
 */
class LC912Solution {

    void merge(int[] arr, int low, int high) {
        int mid = (low+high)/2;
        int[] tempArr = new int[high-low+1];

        int i = low;
        int j = mid+1;

        int k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            tempArr[k++] = arr[i++];
        }

        while (j <= high) {
            tempArr[k++] = arr[j++];
        }


        for (int k2 = 0; k2 < tempArr.length; k2++) {
            arr[low + k2] = tempArr[k2];
        }
    }

    void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, high);
        }
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
}

public class LC912SortAnArray {
    public static void main(String[] args) {
        LC912Solution solution = new LC912Solution();

        int[] array = SystemUtils.takeIntArrayInput("enter array elements: ");

        int[] sortedArray = solution.sortArray(array);

        ArrayUtils.printIntArray(sortedArray);
    }
}
