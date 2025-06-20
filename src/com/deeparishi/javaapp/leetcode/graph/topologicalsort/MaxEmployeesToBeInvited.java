package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import java.util.*;

//  https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting

public class MaxEmployeesToBeInvited {

    public static void main(String[] args) {

        int[] one = {2, 2, 1, 2};
        int[] two = {1, 2, 0};
        int[] three = {3, 0, 1, 4, 1};

        System.out.println(maximumInvitations(one));
        System.out.println(maximumInvitations(two));
        System.out.println(maximumInvitations(three));

    }

    public static int maximumInvitations(int[] favorite) {
        return Math.max(findMaxCycle(favorite), topologicalSort(favorite));
    }

    // Helper method to find the length of the maximum cycle
    private static int findMaxCycle(int[] favorites) {

        int n = favorites.length;
        boolean[] visited = new boolean[n]; // To keep track of visited nodes
        int maxCycleSize = 0; // Store the size of the longest cycle

        // Iterate through each node to find cycles
        for (int startNode = 0; startNode < n; ++startNode) {

            if (visited[startNode]) {
                // If the node is already visited, skip it
                continue;
            }
            List<Integer> cycle = new ArrayList<>(); // To store the current cycle
            int currentNode = startNode;

            // Traverse the graph until a cycle is formed
            while (!visited[currentNode]) {
                cycle.add(currentNode);
                visited[currentNode] = true;
                currentNode = favorites[currentNode];
            }

            // Check if current node is part of the cycle
            for (int k = 0; k < cycle.size(); ++k) {
                if (cycle.get(k) == currentNode) {
                    // Update max cycle length if a longer cycle is found
                    maxCycleSize = Math.max(maxCycleSize, cycle.size() - k);
                    break;
                }
            }
        }
        return maxCycleSize;
    }

    // helper method to perform topological sorting and find the maximum length
    private static int topologicalSort(int[] favorites) {

        int n = favorites.length;
        int[] inDegree = new int[n]; // To keep track of in-degrees
        int[] distance = new int[n]; // To keep track of max distances to each node
        Arrays.fill(distance, 1);    // Initialize distances to 1
        for (int favorite : favorites) {
            inDegree[favorite]++;
        }

        Deque<Integer> queue = new ArrayDeque<>(); // Queue for BFS
        // Adding all nodes with in-degree 0 to the queue
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            int nextNode = favorites[currentNode];
            // Update the distance for the next node
            distance[nextNode] = Math.max(distance[nextNode], distance[currentNode] + 1);
            // Reduce in-degree and add the next node to queue if its in-degree becomes 0
            if (--inDegree[nextNode] == 0) {
                queue.offer(nextNode);
            }
        }

        int answer = 0;
        // Look for pairs of nodes and sum up distances for pairs
        // that are mutually pointing to each other
        for (int i = 0; i < n; ++i) {
            if (i == favorites[favorites[i]]) {
                answer += distance[i];
            }
        }
        return answer;
    }
}