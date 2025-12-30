package com.dsaj.concepts.dsa.stack.use;

import com.dsaj.concepts.dsa.stack.StackUsingArray;

public class StackUsingLLUse {
    public static void main(String[] args) {
        StackUsingArray<Integer> stack = new StackUsingArray<>(Integer.class);
        stack.push(10);
        stack.push(20);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.size());

        // StackUsingArray<String> stack = new StackUsingArray<>(String.class);
        // stack.push("abc");
        // stack.push("def");
        // System.out.println(stack.pop());
        // System.out.println(stack.peek());
        // System.out.println(stack.size());
    }
}
