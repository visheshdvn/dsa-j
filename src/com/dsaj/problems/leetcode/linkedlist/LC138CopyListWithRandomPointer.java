package com.dsaj.problems.leetcode.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
}


class LC138CopyListWithRandomPointerArraySolution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        } else if (head.next == null) {
            Node node = new Node(head.val);
            if(head.random == head) {
                node.random = node;
            }
            return node;
        }

        Map<Node, Node> nodeToCopyNode = new LinkedHashMap<>();
        
        Node headCopy = new Node(head.val);
        Node node = headCopy;
        Node itr = head.next;

        nodeToCopyNode.put(head, headCopy);

        while (itr != null) {
            Node copy = new Node(itr.val);
            nodeToCopyNode.put(itr, copy);
            
            node.next = copy;
            node = node.next;
            itr = itr.next;
        }

        node = headCopy;
        itr = head;
        while (itr != null) {
            Node myRandom = itr.random;
            node.random = nodeToCopyNode.get(myRandom);

            itr = itr.next;
            node = node.next;
        }

        return headCopy;
    }
}

class LC138CopyListWithRandomPointerSinglePassSolution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        Map<Node, Node> nodeToCopy = new LinkedHashMap<>();
        nodeToCopy.put(head, new Node(head.val));

        Node back = head, front = head.next;

        while (back != null) {
            if(!nodeToCopy.containsKey(back)) {
                nodeToCopy.put(back, new Node(back.val));
            }
            Node node = nodeToCopy.get(back);

            if (front != null) {
                node.next = nodeToCopy.getOrDefault(front, new Node(front.val));
                nodeToCopy.putIfAbsent(front, node.next);
                front = front.next;
            }

            Node random = back.random;
            if(random != null) {
                node.random = nodeToCopy.getOrDefault(random, new Node(random.val));
                nodeToCopy.putIfAbsent(random, node.random);
            }

            back = back.next;
        }

        return nodeToCopy.get(head);
    }
}

class LC138CopyListWithRandomPointerSinglePassSolutionFaster {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return head;
        }

        Map<Node, Node> nodeToCopyNode = new LinkedHashMap<>();
        
        Node headCopy = new Node(head.val);
        Node node = headCopy;
        Node back = head, front = head.next;

        nodeToCopyNode.put(head, headCopy);

        while (back != null) {
            if (front != null) {
                Node nextNode;
                if(!nodeToCopyNode.containsKey(front)) {
                    nextNode = new Node(front.val);
                    nodeToCopyNode.put(front, nextNode);
                } else {
                    nextNode = nodeToCopyNode.get(front);
                }
                node.next = nextNode;
                front = front.next;
            }

            Node random = back.random;
            if(random != null) {
                Node randomCopy;
                if(!nodeToCopyNode.containsKey(random)) {
                    randomCopy = new Node(random.val);
                    nodeToCopyNode.put(random, randomCopy);
                } else {
                    randomCopy = nodeToCopyNode.get(random);
                }
                node.random = randomCopy;
            }

            node = node.next;
            back = back.next;
        }

        return headCopy;
    }
}

public class LC138CopyListWithRandomPointer {

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print("Node value: " + current.val);
            if (current.random != null) {
                System.out.print(", Random points to: " + current.random.val);
            } else {
                System.out.print(", Random points to: null");
            }
            System.out.println();
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LC138CopyListWithRandomPointerSinglePassSolutionFaster solution = new LC138CopyListWithRandomPointerSinglePassSolutionFaster();

        Node node5 = new Node(1);
        Node node4 = new Node(10, node5);
        Node node3 = new Node(11, node4);
        Node node2 = new Node(13, node3);
        Node node1 = new Node(7, node2);

        node5.random = node1;
        node4.random = node3;
        node2.random = node1;
        printList(node1);
        System.out.println("\n --- \n");
        printList(solution.copyRandomList(node1));
    }
}
