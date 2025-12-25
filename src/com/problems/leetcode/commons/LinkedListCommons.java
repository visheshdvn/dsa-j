package com.problems.leetcode.commons;

public class LinkedListCommons {
    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class LinkedListUtils {
        public static ListNode constructLL(Integer[] array) {
            if (array == null || array.length == 0) {
                return null;
            }

            ListNode head = new ListNode(array[0]);
            ListNode tail = head;

            for (int i = 1; i < array.length; i++) {
                ListNode node = new ListNode(array[i]);
                tail.next = node;
                tail = tail.next;
            }

            return head;
        }

        public static void printLL(ListNode head) {
            ListNode node = head;

            while (node != null) {
                System.err.print(node.val + " -> ");
                node = node.next;
            }
            System.err.println("null");
        }
    }
}
