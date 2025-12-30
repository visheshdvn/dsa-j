package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC203Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode temp = new ListNode(-1, head);
        ListNode back = temp, front = temp.next;

        while (front != null) {
            if (front.val != val) {
                back.next = front;
                back = back.next;
            }

            front = front.next;
        }
        back.next = front;

        return temp.next;
    }
}

public class LC203RemoveLLElements {

    public static void main(String[] args) {
        LC203Solution solution = new LC203Solution();

        Integer[] llData = SystemUtils.takeIntegerArrayInput("Enter linked list data: ");
        Integer num = SystemUtils.takeIntInput("Enter value to delete: ");

        ListNode head = LinkedListUtils.constructLL(llData);
        LinkedListUtils.printLL(head);

        ListNode revHead = solution.removeElements(head, num);

        LinkedListUtils.printLL(revHead);
    }
}