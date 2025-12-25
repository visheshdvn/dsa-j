package com.dsaj.concepts.dsa.utils;

public class ArrayUtils {

    public static void printIntArray(int[] array) {
        for (int i : array) {
            System.err.print(i + " ");
        }
        System.err.print("\n");
    }

    public static <T> void printArray(T[] array) {
        for (T i : array) {
            System.err.print(i + " ");
        }
        System.err.print("\n");
    }
}
