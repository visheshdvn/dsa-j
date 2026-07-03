package com.dsaj.problems.leetcode.priorityqueue;

import java.util.PriorityQueue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

public class LC703KthLargestElementInStream {
    public static void main(String[] args) {
        int k = SystemUtils.takeIntInput("Enter value of k: ");
        int[] nums = SystemUtils.takeIntArrayInput("Enter initial numbers (space-separated): ");
        
        KthLargest kthLargest = new KthLargest(k, nums);

        while (true) {
            int val = SystemUtils.takeIntInput("Enter a number to add (or type 'exit' to quit): ");
            int kthLargestValue = kthLargest.add(val);
            System.out.println("The " + k + "th largest element is: " + kthLargestValue);
        }
    }
}
