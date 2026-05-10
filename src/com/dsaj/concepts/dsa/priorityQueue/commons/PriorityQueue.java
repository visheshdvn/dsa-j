package com.dsaj.concepts.dsa.priorityQueue.commons;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    List<Integer> heap = new ArrayList<>();
    
    public Boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public int getMin() {
        if(this.isEmpty()) {
            throw new IllegalAccessError("Error in getMin() : heap is empty");
        }
        return heap.get(0);
    }

    public void insert(int element) {
        heap.add(element);

        int child = this.size()-1;
        int parent = (child -1) / 2;
        while (child > 0 && heap.get(child) < heap.get(parent)) {
            int temp = heap.get(parent);
            heap.set(parent, heap.get(child));
            heap.set(child, temp);

            child = parent;
            parent = (parent -1) /2;
        }
    }

    public int removeMin() {
        if(this.isEmpty()) {
            throw new IllegalAccessError("Error in removeMin() : heap is empty");
        }

        int lastIndex = this.size() - 1;
        int minElement = heap.get(0);
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        int parent = 0;
        int leftChild = 2*parent + 1;
        int rightChild = 2*parent + 2;

        while (leftChild < this.size()) {
            int minIndex = parent;

            if (heap.get(leftChild) < heap.get(minIndex)) {
                minIndex = leftChild;
            }

            if (rightChild < this.size() && heap.get(rightChild) < heap.get(minIndex)) {
                minIndex = rightChild;
            }

            if (minIndex == parent) {
                break;
            }

            int temp = heap.get(parent);
            heap.set(parent, heap.get(minIndex));
            heap.set(minIndex, temp);

            parent = minIndex;
            leftChild = 2*parent + 1;
            rightChild = 2*parent + 2;
        }

        return minElement;
    }

    public List<Integer> toList() {
        return new ArrayList<>(heap);
    }
}
