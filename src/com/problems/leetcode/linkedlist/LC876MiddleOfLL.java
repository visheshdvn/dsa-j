/*
 * Leetcode tags: LinkedList, Two Pointers
 */

package com.problems.leetcode.linkedlist;

import com.concepts.dsa.utils.SystemUtils;
import com.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC876Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }
}

public class LC876MiddleOfLL {

    public static void main(String[] args) {

        LC876Solution solution = new LC876Solution();

        Integer[] arr = SystemUtils.takeIntegerArrayInput("Enter array values: ");

        ListNode head = LinkedListUtils.constructLL(arr);

        ListNode middleNode = solution.middleNode(head);

        System.out.println(middleNode.val);
    }
}