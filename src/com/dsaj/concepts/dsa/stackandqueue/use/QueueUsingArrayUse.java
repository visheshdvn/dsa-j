package com.dsaj.concepts.dsa.stackandqueue.use;

import com.dsaj.concepts.dsa.stackandqueue.commons.QueuesUsingArray;
import com.dsaj.concepts.dsa.utils.ArrayUtils;

public class QueueUsingArrayUse {
    public static void main(String[] args) {
        QueuesUsingArray<Integer> queue = new QueuesUsingArray<>(Integer.class, 5);

        ArrayUtils.printArray(queue.toArray());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        ArrayUtils.printArray(queue.toArray());
        
        queue.dequeue();
        queue.dequeue();
        ArrayUtils.printArray(queue.toArray());
        
        queue.dequeue();
        ArrayUtils.printArray(queue.toArray());
        
        queue.enqueue(4);
        queue.enqueue(5);
        ArrayUtils.printArray(queue.toArray());
        
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        ArrayUtils.printArray(queue.toArray());
        
        queue.dequeue();
        queue.enqueue(9);
        queue.dequeue();
        queue.enqueue(10);
        ArrayUtils.printArray(queue.toArray());
    }
}
