package com.dsaj.concepts.dsa.stackandqueue.use;

import com.dsaj.concepts.dsa.linkedlist.commons.LinkedListUtils;
import com.dsaj.concepts.dsa.stackandqueue.QueueUsingLL;

public class QueueUsingLLUse {
    // private final LinkedListUtils<Integer> llUtils = new LinkedListUtils<>();

    public static void main(String[] args) {
        QueueUsingLL<Integer> queue = new QueueUsingLL<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        LinkedListUtils.printLL(queue.getQueue().getHead());

        System.out.println("removing: " + queue.dequeue());
        System.out.println("removing: " + queue.dequeue());
        LinkedListUtils.printLL(queue.getQueue().getHead());

        System.out.println("removing: " + queue.dequeue());
        LinkedListUtils.printLL(queue.getQueue().getHead());
        
        queue.enqueue(4);
        LinkedListUtils.printLL(queue.getQueue().getHead());
    }
}
