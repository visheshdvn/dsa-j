package com.dsaj.problems.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC1971FindIfPathExistsSolutionNaive {

    private void traverseFromSource(int[][] graph, int source, int destination, boolean[] visited) {
        int[] children = graph[source];
        visited[source] = true;

        if (source == destination) {
            return;
        }

        for (int i = 0; i < children.length; i++) {
            if (graph[source][i] == 1 && !visited[i]) {
                traverseFromSource(graph, i, destination, visited);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[][] graph = new int[n][n];

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        // find if path exists
        boolean[] visited = new boolean[n];
        traverseFromSource(graph, source, destination, visited);
        return visited[destination];
    }
}

class LC1971FindIfPathExistsSolution {

    private void traverseFromSource(Map<Integer, List<Integer>> graph, int source, int destination, boolean[] visited) {
        visited[source] = true;

        if (source == destination) {
            return;
        }

        List<Integer> children = graph.get(source);

        if (children == null) {
            return;
        }

        for (int i = 0; i < children.size(); i++) {
            if (!visited[children.get(i)]) {
                traverseFromSource(graph, children.get(i), destination, visited);
            }
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            List<Integer> children;
            
            // straight edge
            children = graph.getOrDefault(src, new ArrayList<>());
            children.add(dest);
            graph.put(src, children);

            // invert edge
            children = graph.getOrDefault(dest, new ArrayList<>());
            children.add(src);
            graph.put(dest, children);
        }

        // find if path exists
        boolean[] visited = new boolean[n];
        traverseFromSource(graph, source, destination, visited);
        return visited[destination];
    }
}

public class LC1971FindIfPathExists {
    public static void main(String[] args) {
        LC1971FindIfPathExistsSolution solution = new LC1971FindIfPathExistsSolution();

        int n = SystemUtils.takeIntInput("Enter the number of nodes: ");
        int[][] edges = { { 0, 7 }, { 0, 8 }, { 6, 1 }, { 2, 0 }, { 0, 4 }, { 5, 8 }, { 4, 7 }, { 1, 3 }, { 3, 5 },
                { 6, 5 } };

        // int k = SystemUtils.takeIntInput("Enter number of edges: ");
        // int[][] edges = new int[k][2];

        // for (int i = 0; i < k; i++) {
        // int[] edge = SystemUtils.takeIntArrayInputofSize("Enter edge value: ", 2);
        // edges[i] = edge;
        // }

        int source = SystemUtils.takeIntInput("Enter source vertex: ");
        int destination = SystemUtils.takeIntInput("Enter destination vertex: ");

        System.out.println(solution.validPath(n, edges, source, destination));
    }
}
