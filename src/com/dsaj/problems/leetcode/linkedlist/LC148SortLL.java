package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC148Solution {

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

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head != null && head.next != null) {
            ListNode middle = middleNode(head);

            ListNode leftHead = head, rightHead = middle.next;
            middle.next = null;

            leftHead = sortList(leftHead);
            rightHead = sortList(rightHead);

            return mergeTwoLists(leftHead, rightHead);
        }

        return head;
    }
}

public class LC148SortLL {
    public static void main(String[] args) {
        LC148Solution solution = new LC148Solution();

        // construct first LL
        Integer[] arr = SystemUtils.takeIntegerArrayInput("Enter first LL values: ");
        ListNode head = LinkedListUtils.constructLL(arr);

        LinkedListUtils.printLL(head);

        ListNode newHead = solution.sortList(head);

        LinkedListUtils.printLL(newHead);
    }
}
