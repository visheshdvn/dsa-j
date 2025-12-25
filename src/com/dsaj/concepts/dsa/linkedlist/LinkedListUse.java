package com.dsaj.concepts.dsa.linkedlist;

import com.dsaj.concepts.dsa.linkedlist.commons.LinkedList;
import com.dsaj.concepts.dsa.linkedlist.commons.LinkedListUtils;
import com.dsaj.concepts.dsa.linkedlist.commons.Node;
import com.dsaj.concepts.dsa.utils.SystemUtils;

public class LinkedListUse {

    // utils contains functions to perform basic operations on LinkedList
    private static final LinkedListUtils<Integer> utils = new LinkedListUtils<>();
    private static final LinkedList<Integer> ll = new LinkedList<>();

    private static void printNodeAtIndex() {
        Node<Integer> head = ll.getHead();

        // both are valid ways to get a node at any index
        int index = SystemUtils.takeIntInput("Enter index: ");
        Node<Integer> node1 = ll.getNodeAtIndex(index);
        Node<Integer> node2 = utils.getNodeAtIndex(head, index);

        System.out.println("Both nodes are same : " + (node1 == node2));
        System.out.println("data : " + (node1 == null ? null : node1.getData()));
    }

    private static void deleteNodeAtIndex() {
        // delete operation testing
        int delIndex = SystemUtils.takeIntInput("Enter index to delete: ");
        ll.deleteNodeAtIndex(delIndex);
        ll.print();
    }

    public static void main(String[] args) {

        // LinkedList<Integer> ll = new LinkedList<>();
        Node<Integer> head = ll.buildLLFromArray(SystemUtils.takeIntegerArrayInput("Enter array values: "));

        // both are valid ways to print the linked list
        ll.print();
        utils.printLL(head);

        // printNodeAtIndex();

        // both are valid ways to insert a node at any index
        head = ll.insert(99, 1);
        ll.print();

        // calling utils.insert doesn't update the head pointer inside ll
        // we have to call the ll.setHead manually
        head = utils.insert(head, 98, 0);
        ll.setHead(head);
        utils.printLL(head); // or ll.print()

        deleteNodeAtIndex();
    }
}
