package com.dsaj.concepts.dsa.graphs.use;

import com.dsaj.concepts.dsa.graphs.commons.Graph;

public class GraphUse {
    public static void main(String[] args) {
        Graph graph = new Graph(5, 4);
        graph.buildGraph();

        graph.printMatrixVew();
        System.out.println();
        // graph.printDFS();

        graph.printBFS();
    }
}
