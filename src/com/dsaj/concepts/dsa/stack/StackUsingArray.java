package com.dsaj.concepts.dsa.stack;

import com.dsaj.concepts.dsa.basics.oops.DynamicArray;

public class StackUsingArray<T> {
    private DynamicArray<T> array;

    public StackUsingArray(Class<T> clazz) {
        this.array = new DynamicArray<>(clazz);
    }

    public void push(T item) {
        array.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array.get(array.size() - 1);
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int size() {
        return array.size();
    }
}
