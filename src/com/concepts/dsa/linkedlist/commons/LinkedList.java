package com.concepts.dsa.linkedlist.commons;

import java.util.List;

public class LinkedList<T> {

    private final LinkedListUtils<T> myUtils = new LinkedListUtils<>();
    
    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    /*
     * linked list operations
     */

    public Node<T> getNodeAtIndex(int index) {
        return myUtils.getNodeAtIndex(this.head, index);
    }

    public void print() {
        myUtils.printLL(this.head);
    }

    public Node<T> insert(T data, int index) {
        this.head = myUtils.insert(this.head, data, index);
        return this.head;
    }

    public Integer getLength() {
        return myUtils.getLength(head);
    }

    public Node<T> deleteNodeAtIndex(int index) {
        this.head = myUtils.deleteNodeAtIndex(this.head, index);
        return head;
    }

    /*
     * builder methods
     */
    public Node<T> buildLLFromList(List<T> data) {
        Node<T> head = myUtils.buildLLFromList(data);
        this.head = head;
        return head;
    }

    public Node<T> buildLLFromArray(T[] array) {
        Node<T> head = myUtils.buildLLFromArray(array);
        this.head = head;
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
