package com.dsaj.concepts.dsa.priorityQueue.use;

import com.dsaj.concepts.dsa.priorityQueue.commons.PriorityQueue;

public class PriorityQueueUse {
    public static void main(String[] args) {
            PriorityQueue pq = new PriorityQueue();

            int[] elements = {5, 2, 8, 1, -1, 0, -3};
            for (int element : elements) {
                pq.insert(element);
            }
    
            // System.out.println(pq.getMin()); // Output: 1
            // System.out.println(pq.removeMin()); // Output: 1
            // System.out.println(pq.getMin()); // Output: 2

            // ArrayUtils.printList(pq.toList());

            while (!pq.isEmpty()) {
                System.out.println(pq.removeMin());
            }
    }
}
