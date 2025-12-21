package com.dsa.basics.oops;

import com.dsa.utils.ArrayUtils;

class DynamicArray {
    private int[] array;
    private int nextIndex = 0;

    DynamicArray() {
        setSize(10);
    }

    DynamicArray(int n) {
        setSize(n);
    }

    public int size() {
        return this.nextIndex;
    }

    public void add(int n) {
        if (this.nextIndex >= this.array.length) {
            setSize(2 * this.array.length);
        }
        array[nextIndex++] = n;
    }

    public void set(int index, int value) {
        if (index < this.array.length && index >= 0) {
            array[index] = value;
        }
    }

    public int get(int index) {
        if (index < this.size() && index >= 0) {
            return array[index];
        }

        return Integer.MIN_VALUE;
    }

    public int removeLast() {
        if (!this.isEmpty()) {
            this.nextIndex--;
            int n = this.array[this.nextIndex];
            this.array[this.nextIndex] = 0;
            return n;
        }

        return Integer.MIN_VALUE;
    }

    public boolean isEmpty() {
        return this.nextIndex == 0;
    }

    private void setSize(int n) {
        if (array == null) {
            this.array = new int[n];
        } else {
            int[] newArr = new int[n];
            copyElements(this.array, newArr);
            this.array = newArr;
        }
    }

    private void copyElements(int[] fromArray, int[] toArray) {
        for (int i = 0; i < fromArray.length; i++) {
            toArray[i] = fromArray[i];
        }
    }

    /*
     * getter
     */
    public int[] getArray() {
        return this.array;
    }
}

public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray d = new DynamicArray(3);

        for (int i = 0; i < 8; i++) {
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
        }
    }
}