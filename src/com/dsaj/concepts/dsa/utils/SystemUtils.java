package com.dsaj.concepts.dsa.utils;

import java.util.Scanner;

public class SystemUtils {
    final static Scanner scan = new Scanner(System.in);

    public static int takeIntInput(String message) {
        ask(message);
        int num = scan.nextInt();

        return num;
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

    private static void ask(String message) {
        if (message != null && !message.isEmpty()) {
            System.out.print(message);
        }
    }
}
