package com.dsaj.problems.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

interface LC1971FindIfPathExistsSolutionInterface {
    boolean validPath(int n, int[][] edges, int source, int destination);
}

class LC1971FindIfPathExistsAdjMatrixSolution implements LC1971FindIfPathExistsSolutionInterface {

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

class LC1971FindIfPathExistsAdjListDFSSolution implements LC1971FindIfPathExistsSolutionInterface {

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

/*
 * BFS solution is more efficient than DFS solution as it can find the
 * destination node without traversing the entire graph. In DFS, we may end up
 * traversing the entire graph before finding the destination node, especially
 * if the destination node is located at a deeper level in the graph. On the
 * other hand, BFS explores all nodes at the present depth level before moving
 * on to the nodes at the next depth level, which allows it to find the
 * destination node more quickly if it is located closer to the source node.
 * 
 * Time Complexity: O(V + E), where V is the number of vertices and E is the
 * number of edges in the graph.
 * Space Complexity: O(V), where V is the number of vertices in the graph, due
 * to the visited array and the queue used for BFS.
 * 
 * changing the adjencency list implementation to use array of list instead of
 * map further reduce the space complexity to O(V + E) as we can directly access
 * the list of children for each node using its index in the array, eliminating
 * the need for storing keys in a map.
 */
class LC1971FindIfPathExistsAdjListBFSSolution implements LC1971FindIfPathExistsSolutionInterface {

    private boolean traverseFromSource(List<Integer>[] graph, int source, int destination,
            boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            if (visited[destination]) {
                return true;
            }

            int node = queue.remove();
            List<Integer> children = graph[node];

            for (int i = 0; i < children.size(); i++) {
                int child = children.get(i);
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                }
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            graph[src].add(dest);
            graph[dest].add(src);
        }

        // find if path exists
        boolean[] visited = new boolean[n];
        return traverseFromSource(graph, source, destination, visited);
    }
}

public class LC1971FindIfPathExists {
    public static void main(String[] args) {
        LC1971FindIfPathExistsSolutionInterface solution = new LC1971FindIfPathExistsAdjListBFSSolution();

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
