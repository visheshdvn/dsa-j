// ⭐️
// Dijkstra's algorithm

package com.dsaj.problems.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class LC743NetworkDelayTimeSolution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            int src = time[0], target = time[1], weight = time[2];

            if(!graph.containsKey(src)) {
                graph.put(src, new LinkedList<int[]>());
            }
            graph.get(src).add(new int[]{target, weight});
        }

        // Define Min Heap of edges
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[]{k, 0});

        // Define a hashset to keep track of visited nodes
        Set<Integer> visited = new HashSet<>();

        int res = 0;

        // perform BFS
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int src = top[0], srcWeight = top[1];

            if(visited.contains(src)) {
                continue;
            }
            visited.add(src);
            res = srcWeight;

            if(!graph.containsKey(src)) continue;
            
            for (int[] edge : graph.get(src)) {
                int node = edge[0], weight = edge[1];

                minHeap.offer(new int[]{node, weight + srcWeight});
            }
        }

        return visited.size() == n ? res : -1;
    }
}

public class LC743NetworkDelayTime {
    public static void main(String[] args) {
        // times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;

        LC743NetworkDelayTimeSolution solution = new LC743NetworkDelayTimeSolution();
        System.out.println("Network delay time: " + solution.networkDelayTime(times, n, k));
    }
}
