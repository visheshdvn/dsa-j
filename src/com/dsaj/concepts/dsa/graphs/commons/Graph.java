package com.dsaj.concepts.dsa.graphs.commons;

import com.dsaj.concepts.dsa.stackandqueue.commons.QueueUsingLL;
import com.dsaj.concepts.dsa.utils.SystemUtils;

public class Graph {

    int nodes;
    int edges;
    int[][] graph;

    public Graph() {
        this.nodes = 0;
        this.edges = 0;
    }

    public Graph(int nodes, int edges) {
        this.nodes = nodes;
        this.edges = edges;
        this.graph = new int[nodes][nodes];
    }

    public void buildGraph() {
        for (int i = 0; i < edges; i++) {
            int u = SystemUtils.takeIntInput("Enter the source node of edge " + (i + 1) + ": ");
            int v = SystemUtils.takeIntInput("Enter the destination node of edge " + (i + 1) + ": ");
            graph[u][v] = 1;
            graph[v][u] = 1; // For undirected graph
        }
    }

    private void printHelper(int sv, boolean[] visited) {
        System.out.print(sv + " ");
        visited[sv] = true;

        for (int i = 0; i < graph[sv].length; i++) {
            if (graph[sv][i] == 1 && !visited[i]) {
                printHelper(i, visited);
            }
        }
    }

    public void printDFS() {
        boolean[] visited = new boolean[graph.length];
        
        for (int i = 0; i < graph.length; i++) {
            if(visited[i] == false) {
                System.out.print("Traversal -> ");
                printHelper(i, visited);
                System.out.println();
            }
        }
    }

    private void printBFSHelper(QueueUsingLL<Integer> queue, boolean[] visited) {
        while (!queue.isEmpty()) {
            int node = queue.dequeue();
            System.out.print(node + " ");

            for (int i = 0; i < graph[node].length; i++) {
                if(graph[node][i] == 1 && !visited[i]) {
                    queue.enqueue(i);

                    // mark the node visited as soon as it enter the queue
                    // so that other nodes in queue having edge to it cannot enqueue it again
                    visited[i] = true;
                }
            }
        }
    }

    public void printBFS() {
        boolean[] visited = new boolean[graph.length];
        QueueUsingLL<Integer> queue = new QueueUsingLL<>();

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                queue.enqueue(i);
                visited[i] = true;

                printBFSHelper(queue, visited);
                System.out.println();
            }
        }
    }

    public void printMatrixVew() {
        for (int[] node : graph) {
            for (int i = 0; i < node.length; i++) {
                System.out.print(node[i] + " ");
            }
            System.err.println();
        }
    }
}
