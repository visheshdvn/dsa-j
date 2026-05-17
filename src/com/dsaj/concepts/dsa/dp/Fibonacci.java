package com.dsaj.concepts.dsa.dp;

import java.time.Instant;

import com.dsaj.concepts.dsa.utils.SystemUtils;

public class Fibonacci {
    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static int fibonacciMemoized(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = fibonacciMemoized(n - 1, memo) + fibonacciMemoized(n - 2, memo);
        return memo[n];
    }

    /*
     * Calculates the nth Fibonacci number using an iterative approach.
     * @param n the position in the Fibonacci sequence
     * @return the nth Fibonacci number
     */
    private static int fibonacciIterative(int n) {
        int arr[] = new int[n+1];

        for (int i = 0; i < arr.length; i++) {
            if(i <= 1) {
                arr[i] = i;
                continue;
            }

            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[arr.length-1];
    }

    public static void main(String[] args) {
        int n = SystemUtils.takeIntInput("Enter the value of n: ");
        int[] memo = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        
        Instant start = Instant.now();
        System.out.println("The " + n + "th Fibonacci number is: " + fibonacciMemoized(n, memo));
        System.out.println("Time taken with memoization: " + (Instant.now().toEpochMilli() - start.toEpochMilli()) + " ms");

        start = Instant.now();
        System.out.println("The " + n + "th Fibonacci number is: " + fibonacci(n));
        System.out.println("Time taken without memoization: " + (Instant.now().toEpochMilli() - start.toEpochMilli()) + " ms");

        start = Instant.now();
        System.out.println("The " + n + "th Fibonacci number is: " + fibonacciIterative(n));
        System.out.println("Time taken with iteration: " + (Instant.now().toEpochMilli() - start.toEpochMilli()) + " ms");
    }
}
