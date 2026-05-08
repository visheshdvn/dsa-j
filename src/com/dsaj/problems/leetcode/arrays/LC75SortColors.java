/*
Topics: #arrays, #two-pointers
 */

package com.dsaj.problems.leetcode.arrays;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC75Solution {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void sortColors(int[] nums) {
        int i = 0, j = nums.length-1;

        int itr = 0;
        while (itr <= j) {
            if(nums[itr] == 0) {
                swap(nums, itr++, i++);
            } else if (nums[itr] == 2) {
                swap(nums, itr, j--);
            } else {
                itr++;
            }
        }
    }
}

public class LC75SortColors {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter array elements: ");

        new LC75Solution().sortColors(nums);

        ArrayUtils.printIntArray(nums);
    }
}
