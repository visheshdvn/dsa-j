package com.dsaj.problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class LC33CloneGraphRecursiveSolution {
    
    Map<Node, Node> copyMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (copyMap.containsKey(node)) {
            return copyMap.get(node);
        }

        Node copy = new Node(node.val);
        copyMap.put(node, copy);

        for (Node neighbour : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbour));
        }
        return copy;
    }
}

class LC33CloneGraphIterativeSolution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> copyMap = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(node);
        copyMap.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curr = queue.remove();
            Node currCopy = copyMap.get(curr);

            for (Node neighbour : curr.neighbors) {
                if (!copyMap.containsKey(neighbour)) {
                    copyMap.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                }
                currCopy.neighbors.add(copyMap.get(neighbour));
            }
        }

        return copyMap.get(node);
    }
}

public class LC33CloneGraph {
    public static void main(String[] args) {

    }
}
