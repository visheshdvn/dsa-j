// ⭐
// Topological Sorting using BFS - Kahn's Algorithm

package com.dsaj.problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.dsaj.concepts.dsa.utils.SystemUtils;

// DFS worked better then BFS for this problem
class LC207CourseScheduleNaiveSolution {

    private boolean searchInMapDFS(Map<Integer, List<Integer>> courseToPrerequisite, int courseId, int course, boolean[] visited) {
        if(visited[course] == true) {
            return false;
        }

        List<Integer> prerequisites = courseToPrerequisite.get(course);

        if(prerequisites == null) {
            return false;
        }

        for (int preq : prerequisites) {
            if(preq == courseId) {
                return true;
            }

            boolean containTarget = searchInMapDFS(courseToPrerequisite, courseId, preq, visited);
            visited[preq] = true;

            if(containTarget) {
                return true;
            }
        }

        return false;
    }

    private boolean searchInMapBFS(Map<Integer, List<Integer>> courseToPrerequisite, int courseId, int course, int totalCourses) {

        boolean[] visited = new boolean[totalCourses];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(course);

        visited[course] = true;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            List<Integer> prerequisites = courseToPrerequisite.getOrDefault(currentCourse, new ArrayList<>());

            for (int dependantCourse : prerequisites) {
                if(dependantCourse == courseId) {
                    return true;
                }

                if(!visited[dependantCourse]) {
                    queue.add(dependantCourse);
                    visited[dependantCourse] = true;
                }
            }
        }

        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> courseToPrerequisite = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int courseId = prerequisites[i][0];
            int preq = prerequisites[i][1];

            if(courseId == preq) {
                return false;
            }

            // boolean clashExist = searchInMapDFS(courseToPrerequisite, courseId, preq, new boolean[numCourses]);
            boolean clashExist = searchInMapBFS(courseToPrerequisite, courseId, preq, numCourses);

            IO.println("Course: " + courseId + ", Prerequisite: " + preq + ", Clash Exist: " + clashExist);

            if(clashExist) {
                return false;
            }

            List<Integer> _preq = courseToPrerequisite.getOrDefault(courseId, new ArrayList<>());
            _preq.add(preq);
            courseToPrerequisite.put(courseId, _preq);
        }

        return true;
    }
}

// Kahn's Algorithm Solution
// Time Complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
// Space Complexity: O(n)
class LC207CourseScheduleKahnAlgoSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer> preqToCourse[] = new ArrayList[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int courseId = prerequisites[i][0];
            int preq = prerequisites[i][1];

            indegree[courseId]++;

            if (preqToCourse[preq] == null) {
                preqToCourse[preq] = new ArrayList<>();
            }
            preqToCourse[preq].add(courseId);
        }

        // add all courses with indegree 0 to queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // start looping on queue while its not empty
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;

            List<Integer> depedants = preqToCourse[course];
            if (depedants != null) {
                for (int dependantCourse : depedants) {
                    indegree[dependantCourse]--;
                    if (indegree[dependantCourse] == 0) {
                        queue.offer(dependantCourse);
                    }
                }
            }
        }

        return count == numCourses;
    }
}

public class LC207CourseSchedule {
    public static void main(String[] args) {
        // int numCourses = SystemUtils.takeIntInput("Enter number of courses: ");

        // int noOfPrerequisites = SystemUtils.takeIntInput("Enter number of prerequisites: ");

        // int prerequisites[][] = new int[noOfPrerequisites][2];
        // for(int i = 0; i < noOfPrerequisites; i++) {
        //     int[] pair = SystemUtils.takeIntArrayInputofSize("Enter prerequisite pair " + (i + 1) + ": ", 2);
        //     prerequisites[i] = pair;
        // }

        int numCourses = 3;
        int prerequisites[][] = new int[][] {
            {1, 0},
            {0, 2},
            {2, 1}
        };
        
        LC207CourseScheduleKahnAlgoSolution solution = new LC207CourseScheduleKahnAlgoSolution();
        boolean result = solution.canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + result);
    }
}
