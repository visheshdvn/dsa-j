package com.dsaj.problems.leetcode.linkedlist;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC2Add2NumbersSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode auxHead = new ListNode();
        ListNode node1 = l1, node2 = l2, thisNode = auxHead;

        while (node1 != null && node2 != null) {
            int sum = node1.val + node2.val + carry;

            thisNode.next = new ListNode(sum % 10);
            carry = sum / 10;

            thisNode = thisNode.next;
            node1 = node1.next;
            node2 = node2.next;
        }

        while (node1 != null) {
            int sum = node1.val + carry;

            thisNode.next = new ListNode(sum % 10);
            carry = sum / 10;

            thisNode = thisNode.next;
            node1 = node1.next;
        }

        while (node2 != null) {
            int sum = node2.val + carry;

            thisNode.next = new ListNode(sum % 10);
            carry = sum / 10;

            thisNode = thisNode.next;
            node2 = node2.next;
        }

        if(carry == 1) {
            thisNode.next = new ListNode(carry);
        }

        return auxHead.next;
    }
}

public class LC2Add2Numbers {
    public static void main(String[] args) {
        Integer[] llData1 = SystemUtils.takeIntegerArrayInput("Enter linked list data: ");
        ListNode head1 = LinkedListUtils.constructLL(llData1);

        Integer[] llData2 = SystemUtils.takeIntegerArrayInput("Enter linked list data: ");
        ListNode head2 = LinkedListUtils.constructLL(llData2);

        ListNode soln = new LC2Add2NumbersSolution().addTwoNumbers(head1, head2);

        LinkedListUtils.printLL(soln);
    }
}
