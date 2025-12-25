package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC21Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode currenthead = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currenthead.next = list1;
                currenthead = currenthead.next;
                list1 = list1.next;
            } else if (list2.val < list1.val) {
                currenthead.next = list2;
                currenthead = currenthead.next;
                list2 = list2.next;
            }
        }

        if (list1 == null) {
            currenthead.next = list2;
        }

        if (list2 == null) {
            currenthead.next = list1;
        }

        return head.next;
    }
}

public class LC21MergeTwoSortedLL {
    public static void main(String[] args) {
        LC21Solution solution = new LC21Solution();

        // construct first LL
        Integer[] arr1 = SystemUtils.takeIntegerArrayInput("Enter first LL values: ");
        ListNode head1 = LinkedListUtils.constructLL(arr1);

        // construct second LL
        Integer[] arr2 = SystemUtils.takeIntegerArrayInput("Enter second LL values: ");
        ListNode head2 = LinkedListUtils.constructLL(arr2);

        ListNode newHead = solution.mergeTwoLists(head1, head2);

        LinkedListUtils.printLL(newHead);
    }
}
