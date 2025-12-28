package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC83Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast != null) {
            if (slow.val != fast.val) {
                slow.next = fast;
                slow = slow.next;
            }

            fast = fast.next;
        }
        slow.next = fast;

        return head;
    }
}

public class LC83RemoveDuplicatesFromSortedLL {
    public static void main(String[] args) {
        LC83Solution solution = new LC83Solution();

        Integer[] llData = SystemUtils.takeIntegerArrayInput("Enter linked list data: ");
        ListNode head = LinkedListUtils.constructLL(llData);

        ListNode newHead = solution.deleteDuplicates(head);

        LinkedListUtils.printLL(newHead);
    }
}
