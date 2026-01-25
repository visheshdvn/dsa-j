package com.dsaj.concepts.dsa.stackandqueue.use;

import com.dsaj.concepts.dsa.stackandqueue.commons.StackUsingLL;

public class StackUsingLLUse {
    public static void main(String[] args) {
        // StackUsingLL<Integer> stack = new StackUsingLL<Integer>();
        // stack.push(10);
        // stack.push(20);
        // System.out.println(stack.pop());
        // System.out.println(stack.pop());
        // System.out.println(stack.peek());
        // System.out.println(stack.size());

        StackUsingLL<Integer> stack = new StackUsingLL<Integer>();
        stack.push(12);
        System.out.println(stack.pop());
        stack.push(12);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());

        // StackUsingLL<String> stack = new StackUsingLL<>();
        // stack.push("abc");
        // stack.push("def");
        // System.out.println(stack.pop());
        // System.out.println(stack.peek());
        // System.out.println(stack.size());
    }
}
