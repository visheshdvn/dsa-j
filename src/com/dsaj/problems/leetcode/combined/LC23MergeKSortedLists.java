package com.dsaj.problems.leetcode.combined;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC23MergeKSortedListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode listNode : lists) {
            if(listNode != null) {
                minHeap.offer(listNode);
            }
        }
        
        ListNode head = new ListNode(0);
        ListNode node = head;

        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();

            node.next = min;
            node = node.next;

            if(min.next != null) {
                minHeap.offer(min.next);
            }
        }

        return head.next;
    }
}

public class LC23MergeKSortedLists {
    public static void main(String[] args) {
        LC23MergeKSortedListsSolution solution = new LC23MergeKSortedListsSolution();

        int n = SystemUtils.takeIntInput("Enter number of Linked-Lists : ");
        ListNode[] lists = new ListNode[n];

        for (int i = 0; i < n; i++) {
            Integer[] llData = SystemUtils.takeIntegerArrayInput("Enter linked list data: ");
            Arrays.sort(llData);
            lists[i] = LinkedListUtils.constructLL(llData);
        }

        ListNode mergedHead = solution.mergeKLists(lists);
        System.out.print("Merged List : ");
        LinkedListUtils.printLL(mergedHead);
    }
}
