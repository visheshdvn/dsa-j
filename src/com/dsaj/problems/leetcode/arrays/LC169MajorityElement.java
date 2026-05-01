package com.dsaj.problems.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.SystemUtils;


class LC169Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int elem = nums[i];

            int occurance = count.getOrDefault(elem, 0)+1;
            if (occurance > nums.length/2) {
                return elem;
            }

            count.put(elem, occurance);
        }

        return -1;
    }
}


class LC169SolutionOptimized {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int i = 0; i < nums.length; i++) {
            // When count hits 0, pick a new candidate
            if (count == 0) {
                candidate = nums[i];
            }
            
            // Vote: +1 if it matches the candidate, -1 if it doesn't
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // The problem guarantees a majority element exists, 
        // so 'candidate' is guaranteed to be our answer.
        return candidate;
    }
    
}

public class LC169MajorityElement {

    public static void main(String[] args) {
        // LC169Solution solution = new LC169Solution();
        LC169SolutionOptimized solution = new LC169SolutionOptimized();

        int[] arr = SystemUtils.takeIntArrayInput("Enter array elements: ");

        int element = solution.majorityElement(arr);
        System.out.println("element: " + element);
    }
}