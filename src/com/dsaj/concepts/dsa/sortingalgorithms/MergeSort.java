package com.dsaj.concepts.dsa.sortingalgorithms;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

public class MergeSort {

    public static void merge(Integer[] array, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;

        Integer[] ans = new Integer[endIndex - startIndex + 1];

        int i = startIndex, j = mid + 1, k = 0;

        while (i <= mid && j <= endIndex) {
            if (array[i] <= array[j]) {
                ans[k++] = array[i++];
            } else {
                ans[k++] = array[j++];
            }
        }

        while (i <= mid) {
            ans[k++] = array[i++];
        }

        while (j <= endIndex) {
            ans[k++] = array[j++];
        }

        for (int ind = 0; ind < ans.length; ind++) {
            array[startIndex + ind] = ans[ind];
        }
    }

    public static void mergeSort(Integer[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;

            mergeSort(array, startIndex, middle);
            mergeSort(array, middle + 1, endIndex);
            merge(array, startIndex, endIndex);
        }
    }

    public static void main(String[] args) {
        // take array as input from user
        Integer[] array = SystemUtils.takeIntegerArrayInput("Enter numbers to sort: ");

        mergeSort(array, 0, array.length - 1);
        System.out.print("Sorted array: ");
        ArrayUtils.printArray(array);
    }
}
