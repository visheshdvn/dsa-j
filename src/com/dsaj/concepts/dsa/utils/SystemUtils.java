package com.dsaj.concepts.dsa.utils;

import java.util.Scanner;

public class SystemUtils {
    final static Scanner scan = new Scanner(System.in);

    public static int takeIntInput(String message) {
        ask(message);
        int num = scan.nextInt();
        scan.nextLine(); // consume trailing newline left by nextInt()

        return num;
    }

    public static int[] takeIntArrayInput(String message) {
        int n = takeIntInput("Enter size of array: ");
        int arr[] = new int[n];

        ask(message);

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        return arr;
    }

    public static String[] takeStringArrayInput(String message) {
        int n = takeIntInput("Enter size of array: ");
        String arr[] = new String[n];

        ask(message);

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextLine();
        }

        return arr;
    }

    public static Integer[] takeIntegerArrayInput(String message) {
        int n = takeIntInput("Enter size of array: ");
        Integer arr[] = new Integer[n];

        ask(message);

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        return arr;
    }

    public static String takeStringInput(String message) {
        ask(message);
        String str = scan.nextLine();
        return str;
    }

    private static void ask(String message) {
        if (message != null && !message.isEmpty()) {
            System.out.print(message);
        }
    }
}
