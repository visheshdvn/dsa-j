package com.dsaj.problems.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.SystemUtils;


// This is Backtracking solution
class LC46PermutationsRecursiveSolution {

    List<List<Integer>> permutations = new ArrayList<>();

    private void permuteHelper(int[] nums, List<Integer> thisPermutation) {

        if(thisPermutation.size() == nums.length) {
            permutations.add(new ArrayList<>(thisPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!thisPermutation.contains(nums[i])) {
                thisPermutation.add(nums[i]);
                permuteHelper(nums, thisPermutation);
                thisPermutation.removeLast();
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> thisPermutation = new ArrayList<>();
        permuteHelper(nums, thisPermutation);
        return permutations;
    }
}

// Iterative solution is slower than recursive solution for this problem
class LC46PermutationsIterativeSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            permutations.add(new ArrayList<>(List.of(nums[i])));
        }

        int times = nums.length-1;
        while (times --> 0) {
            
            List<List<Integer>> iPermutes = new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {
                for (List<Integer> list : permutations) {
                    if(!list.contains(nums[i])) {
                        List<Integer> _l = new ArrayList<>(list);
                        _l.add(nums[i]);
                        iPermutes.add(_l);
                    }

                }
            }
            permutations = new ArrayList<>(iPermutes);
        }

        return permutations;
    }
}

public class LC46Permutations {
    public static void main(String[] args) {
        LC46PermutationsIterativeSolution solution1 = new LC46PermutationsIterativeSolution();
        LC46PermutationsRecursiveSolution solution = new LC46PermutationsRecursiveSolution();

        int[] nums = SystemUtils.takeIntArrayInput("Enter array numbers: ");

        Long startTime;

        startTime = System.currentTimeMillis();
        List<List<Integer>> result1 = solution1.permute(nums);
        System.out.println("Iterative solution took: " + (System.currentTimeMillis() - startTime) + " ms");

        startTime = System.currentTimeMillis();
        List<List<Integer>> result2 = solution.permute(nums);
        System.out.println("Recursive solution took: " + (System.currentTimeMillis() - startTime) + " ms");

        // for (List<Integer> list : result) {
        //     ArrayUtils.printList(list);
        // }
    }
}