package com.dsaj.concepts.dsa.basics.oops;

import java.lang.reflect.Array;

public class DynamicArray<T> {
    private T[] array;
    private int nextIndex = 0;
    private Class<T> clazz;

    public DynamicArray(Class<T> clazz) {
        this.clazz = clazz;
        this.array = (T[]) Array.newInstance(clazz, 10);
        setSize(10);
    }

    public DynamicArray(Class<T> clazz, int size) {
        this.clazz = clazz;
        this.array = (T[]) Array.newInstance(clazz, size);
        setSize(size);
    }

    public int size() {
        return this.nextIndex;
    }

    public void add(T n) {
        if (this.nextIndex >= this.array.length) {
            setSize(2 * this.array.length);
        }
        array[nextIndex++] = n;
    }

    public void set(int index, T value) {
        if (index < this.array.length && index >= 0) {
            array[index] = value;
        }
    }

    public T get(int index) {
        if (index < this.nextIndex && index >= 0) {
            return array[index];
        }

        throw new IllegalStateException();
    }

    public T removeLast() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }

        this.nextIndex--;
        T n = this.array[this.nextIndex];
        this.array[this.nextIndex] = null;
        return n;
    }

    public boolean isEmpty() {
        return this.nextIndex == 0;
    }

    private void setSize(int n) {
        if (array == null) {
            // this.array = new T[n];
            this.array = (T[]) Array.newInstance(this.clazz, n);
        } else {
            T[] newArr = (T[]) Array.newInstance(this.clazz, n);
            // Integer[] newArr = new Integer[n];
            copyElements(this.array, newArr);
            this.array = newArr;
        }
    }

    private void copyElements(T[] fromArray, T[] toArray) {
        for (int i = 0; i < fromArray.length; i++) {
            toArray[i] = fromArray[i];
        }
    }

    /*
     * getter
     */
    public T[] getArray() {
        return this.array;
    }
}
