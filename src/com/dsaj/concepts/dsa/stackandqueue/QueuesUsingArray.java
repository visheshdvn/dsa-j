package com.dsaj.concepts.dsa.stackandqueue;

import java.lang.reflect.Array;

public class QueuesUsingArray<T> {
    private T[] queue;
    private int size = 0;
    private int front = -1, rear = -1;

    public QueuesUsingArray(Class<T> clazz) {
        this.queue = (T[]) Array.newInstance(clazz, 10);
    }

    public QueuesUsingArray(Class<T> clazz, int capacity) {
        this.queue = (T[]) Array.newInstance(clazz, capacity);
    }

    public void enqueue(T element) {
        if (this.isFull()) {
            throw new IllegalStateException("Cannot run enqueue: Queue is Full.");
        }

        if (this.isEmpty()) {
            front = increment(front);
        }

        rear = increment(rear);
        this.queue[rear] = element;
        size++;
    }

    public T dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot run dequeue: Queue is empty");
        }

        T element = this.queue[front];
        this.queue[front] = null;
        front = increment(front);
        size--;

        if (size == 0) {
            front = -1;
            rear = -1;
        }

        return element;
    }

    /*
     * helper functions
     */
    public Boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isFull() {
        return size == queue.length;
    }

    public T front() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is Empty.");
        }

        return this.queue[front];
    }

    /* */
    private int increment(int index) {
        return (index + 1) % queue.length;
    }

    public T[] toArray() {
        return this.queue;
    }
}
