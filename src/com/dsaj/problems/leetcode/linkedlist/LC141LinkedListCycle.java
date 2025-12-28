package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC141Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next, slow = head;

        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}

public class LC141LinkedListCycle {
    public static void main(String[] args) {
        LC141Solution solution = new LC141Solution();

        ListNode node5 = new ListNode(0);
        ListNode node4 = new ListNode(0, node5);
        ListNode node3 = new ListNode(0, node4);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(0, node2);

        node5.next = node4;

        boolean hasCycle = solution.hasCycle(node1);

        System.out.println("cycle present = " + hasCycle);
    }
}
