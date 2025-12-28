package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC206Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null, currNode = head, nextNode;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = nextNode;
        }

        return prev;
    }
}

public class LC206ReverseLL {
    public static void main(String[] args) {
        LC206Solution solution = new LC206Solution();

        Integer[] llData = SystemUtils.takeIntegerArrayInput("Enter linked list data: ");
        ListNode head = LinkedListUtils.constructLL(llData);
        LinkedListUtils.printLL(head);

        ListNode revHead = solution.reverseList(head);

        LinkedListUtils.printLL(revHead);
    }
}
