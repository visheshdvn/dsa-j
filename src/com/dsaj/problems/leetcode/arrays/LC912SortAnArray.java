package com.dsaj.problems.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

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


/*
    Counting Sort
 */
class LC912SolutionAlternative {

    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];

            countMap.put(n, countMap.getOrDefault(n, 0)+1);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        int[] sortedArray = new int[nums.length];
        int i = 0;

        for (int n = min; n <= max; n++) {
            int count = countMap.getOrDefault(n, 0);

            for (int j = 0; j < count; j++) {
                sortedArray[i++] = n;
            }
        }

        return sortedArray;
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
