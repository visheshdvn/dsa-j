package com.dsa.linkedlist;

import com.dsa.linkedlist.commons.LinkedList;
import com.dsa.linkedlist.commons.LinkedListUtils;
import com.dsa.linkedlist.commons.Node;
import com.dsa.utils.SystemUtils;

public class LinkedListUse {

    // utils contains functions to perform basic operations on LinkedList
    private static final LinkedListUtils<Integer> utils = new LinkedListUtils<>();

    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.buildLLFromArray(SystemUtils.takeIntegerArrayInput("Enter array values: "));

        // both are valid ways to print the linked list
        ll.print();
        utils.printLL(head);

        // both are valid ways to get a node at any index
        int index = SystemUtils.takeIntInput("Enter index: ");
        Node<Integer> node1 = ll.getNodeAtIndex(index);
        Node<Integer> node2 = utils.getNodeAtIndex(head, index);

        System.out.println("Both nodes are same : " + (node1 == node2));
        System.out.println("data : " + (node1 == null ? null : node1.getData()));
    }
}
