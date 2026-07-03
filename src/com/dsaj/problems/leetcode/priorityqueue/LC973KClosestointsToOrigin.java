package com.dsaj.problems.leetcode.priorityqueue;

import java.util.PriorityQueue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

class LC973KClosestointsToOriginSolution {
    class Coordinate {
        int[] points;
        double distanceToOrigin;

        public Coordinate(int[] points, double distanceToOrigin) {
            this.points = points;
            this.distanceToOrigin = distanceToOrigin;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Coordinate> maxHeap = new PriorityQueue<>(
            (a, b) -> Double.compare(a.distanceToOrigin, b.distanceToOrigin)
        );

        for (int[] point : points) {
            double distanceToOrigin = point[0]*point[0]+point[1]*point[1];

            Coordinate coordinate = new Coordinate(point, distanceToOrigin);
            maxHeap.offer(coordinate);
        }

        int[][] closestOnes = new int[k][2];
        for (int i = 0; i < k; i++) {
            Coordinate coordinate = maxHeap.poll();
            closestOnes[i] = coordinate.points;
        }

        return closestOnes;
    }
}

public class LC973KClosestointsToOrigin {
    public static void main(String[] args) {
        LC973KClosestointsToOriginSolution solution = new LC973KClosestointsToOriginSolution();

        int nPoints = SystemUtils.takeIntInput("Enter number of points: ");

        int[][] points = new int[nPoints][2];
        for (int i = 0; i < nPoints; i++) {
            points[i] = SystemUtils.takeIntArrayInputofSize("Enter point " + (i + 1) + " coordinates: ", 2);
        }

        int k = SystemUtils.takeIntInput("Enter value of k: ");

        System.err.println(k + " closest points to origin are: ");

        int[][] closestPoints = solution.kClosest(points, k);

        for (int[] point : closestPoints) {
            System.err.println(point[0] + " " + point[1]);
        }
    }
}