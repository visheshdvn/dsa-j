package com.dsa.linkedlist;

import com.dsa.linkedlist.commons.LinkedList;
import com.dsa.linkedlist.commons.LinkedListUtils;
import com.dsa.linkedlist.commons.Node;

public class LinkedListUse {

    // utils contains functions to perform basic operations on LinkedList
    private static LinkedListUtils<Integer> utils = new LinkedListUtils<>();

    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.buildLLFromArray(new Integer[] { 1, 2, 3, 4, 5, 6 });

        // both are valid ways to print the linked list
        ll.print();
        utils.printLL(head);

        // both are valid ways to get a node at any index
        int index = 4;
        Node<Integer> node1 = ll.getNodeAtIndex(index);
        Node<Integer> node2 = utils.getNodeAtIndex(head, index);

        System.out.println("Both nodes are same : " + (node1 == node2));
    }
}
