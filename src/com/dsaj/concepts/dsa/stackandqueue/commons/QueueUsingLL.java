package com.dsaj.concepts.dsa.stackandqueue.commons;

import com.dsaj.concepts.dsa.linkedlist.commons.LinkedList;
import com.dsaj.concepts.dsa.linkedlist.commons.Node;

public class QueueUsingLL<T> {
    private LinkedList<T> queue;
    private int size = 0;

    public QueueUsingLL() {
        queue = new LinkedList<>();
    }

    public void enqueue(T element) {
        queue.add(element);
        size++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot dequeue: Queue is empty");
        }

        Node<T> head = queue.getHead();
        queue.setHead(head.getNext());
        size--;
        return head.getData();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    /* getters */
    public LinkedList<T> getQueue() {
        return this.queue;
    }
}
