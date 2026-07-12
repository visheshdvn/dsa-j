package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC90Subsets2Solution {
    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            path.add(nums[i]);
            backtrack(nums, i + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }
}

public class LC90Subsets2 {
    public static void main(String[] args) {
        int[] nums = SystemUtils.takeIntArrayInput("Enter the elements of the array (space-separated): ");
        List<List<Integer>> result = new LC90Subsets2Solution().subsetsWithDup(nums);

        for (List<Integer> list : result) {
            ArrayUtils.printList(list);
        }
    }
}
