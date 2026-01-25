package com.dsaj.concepts.dsa.stackandqueue.commons;

import com.dsaj.concepts.dsa.linkedlist.commons.LinkedList;

public class StackUsingLL<T> {
    LinkedList<T> stack;

    public StackUsingLL() {
        stack = new LinkedList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        T item = this.peek();
        stack.deleteNodeAtIndex(stack.size() - 1);
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return stack.getNodeAtIndex(stack.size() - 1).getData();
    }

    public int size() {
        return stack.size();
    }

    public Boolean isEmpty() {
        return stack.size() == 0;
    }
}
