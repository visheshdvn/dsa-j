package com.dsa.linkedlist.commons;

import java.util.List;

public class LinkedListUtils<T> {

    /**
     * Prints the linked list to the console.
     * 
     * @param head the head of the linked list
     */
    public void printLL(Node<T> head) {
        Node<T> node = head;

        while (node != null) {
            System.err.print(node.getData() + " -> ");
            node = node.getNext();
        }
        System.err.println("null");
    }

    /**
     * Builds a linked list from a given list.
     * 
     * @param data the given list
     * @return the head of the linked list
     */
    public Node<T> buildLLFromList(List<T> data) {
        if (data == null || data.size() == 0) {
            return null;
        }

        Node<T> head = new Node<>(data.get(0));
        Node<T> tail = head;

        for (int i = 1; i < data.size(); i++) {
            Node<T> newNode = new Node<>(data.get(i));
            tail.setNext(newNode);
            tail = newNode;
        }

        return head;
    }

    /**
     * Builds a linked list from a given array.
     * 
     * @param array the given array
     * @return the head of the linked list
     */
    public Node<T> buildLLFromArray(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        Node<T> head = new Node<>(array[0]);
        Node<T> tail = head;

        for (int i = 1; i < array.length; i++) {
            Node<T> node = new Node<>(array[i]);
            tail.setNext(node);
            tail = tail.next();
        }

        return head;
    }

    /**
     * Returns the length of a linked list.
     * 
     * @param head the head of the linked list
     * @return the length of the linked list
     */
    public int getLength(Node<T> head) {
        Node<T> node = head;
        int length = 0;

        while (node != null) {
            length++;
            node = node.next();
        }

        return length;
    }

    /**
     * Returns the node at a given index in the linked list.
     * 
     * @param head  the head of the linked list
     * @param index  the index of the node to return
     * @return the node at the given index, or null if the index is out of bounds
     */
    public Node<T> getNodeAtIndex(Node<T> head, int index) {
        if (head == null)
            return null;

        int length = getLength(head);

        if (index >= length)
            return null;

        Node<T> node = head;
        for (int i = 1; i <= index; i++) {
            node = node.getNext();
        }

        return node;
    }

    /**
     * Inserts a new node with the given data at the specified index in the linked
     * list.
     * 
     * @param head  the head of the linked list
     * @param data  the data to insert
     * @param index the index at which to insert the new node
     * @return the head of the linked list (may be updated if inserting at index 0)
     */
    public Node<T> insert(Node<T> head, T data, int index) {
        if (index == 0) {
            Node<T> node = new Node<T>(data);
            node.setNext(head);
            head = node;
            return head;
        }

        if (head == null) {
            return null;
        }

        int i = 0;
        Node<T> temp = head;
        while (i < index - 1 && temp != null) {
            i++;
            temp = temp.next();
        }

        if (temp == null) {
            return head;
        }

        Node<T> node = new Node<T>(data);
        node.setNext(temp.next());
        temp.setNext(node);
        return head;
    }

    /**
     * Deletes the node at the specified index in the linked list.
     * 
     * @param head the head of the linked list
     * @param index the index of the node to delete
     * @return the head of the linked list (may be updated if deleting at index 0)
     */
    public Node<T> deleteNodeAtIndex(Node<T> head, int index) {
        int length = getLength(head);

        if (head == null || index >= length) {
            return head;
        }

        if (index == 0) {
            head = head.next();
            return head;
        }

        Node<T> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.next();
        }

        Node<T> del = node.next();
        node.setNext(del.next());

        return head;
    }
}
