package com.dsaj.problems.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC19RemoveNthNodeFromEndOfLLDequeueSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Deque<ListNode> queue = new ArrayDeque<>();

        ListNode node = head;

        while (node != null) {
            if(queue.size() >= n+1) {
                queue.removeFirst();
            }
            queue.addLast(node);
            node = node.next;
        }
        
        if(queue.size() == n) {
            return head.next;
        }
        
        ListNode prev = queue.removeFirst();
        if(prev.next != null) {
            prev.next = prev.next.next;
        }

        return head;
    }
}

class LC19RemoveNthNodeFromEndOfLLTwoPointerSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode auxHead = new ListNode(0, head);
        ListNode front = head, back = auxHead;

        while (n --> 0) {
            front = front.next;
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;

        return auxHead.next;
    }
}

public class LC19RemoveNthNodeFromEndOfLL {
    public static void main(String[] args) {
        LC19RemoveNthNodeFromEndOfLLTwoPointerSolution solution = new LC19RemoveNthNodeFromEndOfLLTwoPointerSolution();

        Integer[] llData = SystemUtils.takeIntegerArrayInput("Enter linked list data: ");
        Integer n = SystemUtils.takeIntInput("Enter n: ");

        ListNode head = LinkedListUtils.constructLL(llData);

        ListNode result = solution.removeNthFromEnd(head, n);
        LinkedListUtils.printLL(result);
    }
}
