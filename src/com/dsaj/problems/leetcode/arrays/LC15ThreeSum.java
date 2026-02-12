package com.dsaj.problems.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC15ThreeSumSolutionNaive {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                Integer target = -(nums[i] + nums[j]);

                if (set.contains(target)) {
                    List<Integer> l = Arrays.asList(nums[i], nums[j], target);
                    Collections.sort(l);
                    result.add(l);
                }

                set.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}

class LC15ThreeSumSolution {
    // private List<Integer> removeDuplicates(int[] nums) {
    //     Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

    //     return new ArrayList<>(set);
    // }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;

            Integer first = nums[i];

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = first + nums[left] + nums[right];

                if (sum == 0) {
                    List<Integer> l = Arrays.asList(first, nums[left], nums[right]);
                    result.add(l);
                    left++;
                    right--;

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}

public class LC15ThreeSum {
    public static void main(String[] args) {
        LC15ThreeSumSolution solution = new LC15ThreeSumSolution();

        int[] nums = SystemUtils.takeIntArrayInput("Enter array values: ");

        List<List<Integer>> ans = solution.threeSum(nums);
        for (List<Integer> list : ans) {
            ArrayUtils.printList(list);
        }
    }
}
