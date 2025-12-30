package com.dsaj.concepts.dsa.basics.oops;

import com.dsaj.concepts.dsa.utils.ArrayUtils;

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