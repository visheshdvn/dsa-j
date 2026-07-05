package com.dsaj.problems.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class Tasks {
    char c;
    int nextTime;

    Tasks(char c, int nextTime) {
        this.c = c;
        this.nextTime = nextTime;
    }
}

class LC621TaskSchedulerPriorityQueueSolution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charNextTime = new LinkedHashMap<>();
        PriorityQueue<Tasks> tasksQueue = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.nextTime, b.nextTime)
        );

        for (char c : tasks) {
            charNextTime.put(c, charNextTime.getOrDefault(c, 1-n-1)+n+1);
            tasksQueue.offer(new Tasks(c, charNextTime.get(c)));
        }

        int cycle = 0;
        while (!tasksQueue.isEmpty()) {
            cycle++;

            if(tasksQueue.peek().nextTime <= cycle) {
                tasksQueue.poll();
            }
        }

        return cycle;
    }
}

class LC621TaskSchedulerPriorityQueueOptimizedSolution {
    public int leastInterval(char[] tasks, int n) {
        // build a frequency map for the tasks
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> frequencies = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                frequencies.offer(freq[i]);
            }
        }

        int time = 0;
        while (!frequencies.isEmpty()) {
            int cycle = n + 1;
            List<Integer> store = new ArrayList<>();
            int taskCount = 0;

            while (cycle --> 0 && !frequencies.isEmpty()) {
                int currFreq = frequencies.poll();

                if (currFreq > 1) {
                    store.add(currFreq-1);
                }

                taskCount++;
            }

            // rebuild the heap with remaining frequencies
            store.forEach(frequencies::offer);

            // suppose n >> distinct tasks - there will be some gaps
            time += (frequencies.isEmpty() ? taskCount : n + 1);
        }

        return time;
    }
}

class LC621TaskSchedulerSolutionOptimized {
    public int leastInterval(char[] tasks, int n) {
        int[] taskCounts = new int[26];
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }

        Arrays.sort(taskCounts);
        int maxCount = taskCounts[25];
        int idleSlots = (maxCount - 1) * n;

        for (int i = 24; i >= 0 && taskCounts[i] > 0; i--) {
            idleSlots -= Math.min(taskCounts[i], maxCount - 1);
        }

        return idleSlots > 0 ? tasks.length + idleSlots : tasks.length;
    }
}

public class LC621TaskScheduler {
    public static void main(String[] args) {
        LC621TaskSchedulerPriorityQueueOptimizedSolution solution = new LC621TaskSchedulerPriorityQueueOptimizedSolution();

        char[] tasks = SystemUtils.takeCharArrayInput("Enter the tasks (as a char array): ");
        int n = SystemUtils.takeIntInput("Enter the cooldown period (n): ");

        System.out.println("Min interval: " + solution.leastInterval(tasks, n));
    }
}

// A B _ A B