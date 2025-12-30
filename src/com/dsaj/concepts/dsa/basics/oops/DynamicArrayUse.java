package com.dsaj.concepts.dsa.basics.oops;

import java.lang.reflect.Array;

import com.dsaj.concepts.dsa.utils.ArrayUtils;

class DynamicArray<T> {
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

        return null;
    }

    public T removeLast() {
        if (!this.isEmpty()) {
            this.nextIndex--;
            T n = this.array[this.nextIndex];
            this.array[this.nextIndex] = null;
            return n;
        }

        return null;
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

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray<Integer> d = new DynamicArray<>(Integer.class, 5);

        for (Integer i = 0; i < 8; i++) {
            d.add(i + 10);
        }

        System.err.println("size of array = " + d.size());
        ArrayUtils.printArray(d.getArray());

        d.set(4, 10);
        System.err.println(d.get(3));
        System.err.println(d.get(4));

        while (!d.isEmpty()) {
            System.err.println(d.removeLast());
            System.err.println("size = " + d.size());
            ArrayUtils.printArray(d.getArray());
        }
    }
}