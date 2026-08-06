package com.dsaj.problems.leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

import com.dsaj.concepts.dsa.utils.SystemUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.LinkedListUtils;
import com.dsaj.problems.leetcode.commons.LinkedListCommons.ListNode;

class LC25ReverseNodesInKGroupSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<List<ListNode>> nodeGroups = new ArrayList<>();

        ListNode node = head;
        while (node != null) {
            List<ListNode> n = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                if (node == null) {
                    break;
                }

                n.add(node);
                node = node.next;
            }

            if (!n.isEmpty()) {
                nodeGroups.add(n);
            }
        }

        for (List<ListNode> list : nodeGroups) {
            if (list.size() < k) {
                break;
            }

            for (int i = list.size() - 2; i >= 0; i--) {
                ListNode thisNode = list.get(i);
                list.get(i + 1).next = thisNode;

                if (i == 0) {
                    thisNode.next = null;
                }
            }
        }

        for (int i = 1; i < nodeGroups.size(); i++) {
            List<ListNode> prevGroup = nodeGroups.get(i - 1);
            List<ListNode> thisGroup = nodeGroups.get(i);

            prevGroup.get(0).next = thisGroup.size() < k ? thisGroup.get(0) : thisGroup.get(k - 1);
        }

        List<ListNode> firstGroup = nodeGroups.get(0);
        if (nodeGroups.size() > 1) {
            return firstGroup.get(k - 1);
        }

        return firstGroup.size() == k ? firstGroup.get(k - 1) : firstGroup.get(0);
    }
}

class LC25ReverseNodesInKGroupOptimalSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            ListNode kth = getKth(temp, k);

            if (kth == null) {
                if(prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextGroup = kth.next;
            kth.next = null;

            reverseLinkedList(temp);

            if(temp == head) {
                head = kth;
            } else {
                prevLast.next = kth;
            }

            prevLast = temp;
            temp = nextGroup;
        }

        return head;
    }

    private void reverseLinkedList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode temp = head;
            head = head.next;

            temp.next = prev;
            prev = temp;
        }
    }

    private ListNode getKth(ListNode node, int k) {
        k -= 1;
        while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }
}

public class LC25ReverseNodesInKGroup {
    public static void main(String[] args) {
        Integer[] arr = SystemUtils.takeIntegerArrayInput("Enter first LL values: ");
        ListNode head = LinkedListUtils.constructLL(arr);

        int k = SystemUtils.takeIntInput("Enter group size: ");

        ListNode result = new LC25ReverseNodesInKGroupOptimalSolution().reverseKGroup(head, k);
        LinkedListUtils.printLL(result);
    }
}
