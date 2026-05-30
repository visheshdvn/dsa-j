package com.dsaj.problems.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.ArrayUtils;
import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC347Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] buckets = new List[nums.length+1];
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0)+1);
        }

        for (Integer num : frequencies.keySet()) {
            Integer frequency = frequencies.get(num);

            if(buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        int[] res = new int[k];
        int added = 0;
        for (int i = buckets.length-1; i >= 0 && added < k; i--) {
            if(buckets[i] == null) continue;

            // it works here bec it is given in the constraints that-
            // "It is guaranteed that the answer is unique."
            for (Integer num: buckets[i]) {
                res[added++] = num;
            }
        }

        return res;
    }
}

public class LC347TopKFrequentElement {

    public static void main(String[] args) {
        LC347Solution solution = new LC347Solution();

        int[] arr = SystemUtils.takeIntArrayInput("Enter array elements: ");
        int k = SystemUtils.takeIntInput("enter value of k: ");

        int[] ans = solution.topKFrequent(arr, k);

        ArrayUtils.printIntArray(ans);
    }
}