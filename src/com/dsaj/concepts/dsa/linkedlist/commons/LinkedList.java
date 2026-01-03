package com.dsaj.concepts.dsa.linkedlist.commons;

import java.util.List;

public class LinkedList<T> {

    private Node<T> head;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    /*
     * linked list operations
     */

    public Node<T> getNodeAtIndex(int index) {
        return LinkedListUtils.getNodeAtIndex(this.head, index);
    }

    public void print() {
        LinkedListUtils.printLL(this.head);
    }

    public Node<T> add(T data) {
        this.head = LinkedListUtils.insert(head, data);
        return this.head;
    }

    public Node<T> insert(T data, int index) {
        this.head = LinkedListUtils.insert(this.head, data, index);
        return this.head;
    }

    public Integer size() {
        return LinkedListUtils.size(head);
    }

    public Node<T> deleteNodeAtIndex(int index) {
        this.head = LinkedListUtils.deleteNodeAtIndex(this.head, index);
        return head;
    }

    /*
     * builder methods
     */
    public Node<T> buildLLFromList(List<T> data) {
        Node<T> head = LinkedListUtils.buildLLFromList(data);
        this.head = head;
        return head;
    }

    public Node<T> buildLLFromArray(T[] array) {
        Node<T> head = LinkedListUtils.buildLLFromArray(array);
        this.head = head;
        return head;
    }
}
