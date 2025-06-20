package com.deeparishi.javaapp.leetcode.graph.bfs;

//https://leetcode.com/problems/find-eventual-safe-states/

import java.util.*;

public class EventualSafeStateBFS {

    public static void main(String[] args) {

        int[][] graph1 = {
                {1},
                {2},
                {3},
                {4, 5},
                {6},
                {6},
                {7},
                {},
                {1, 9},
                {10},
                {8},
                {9}
        };

        int[][] graph = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };



        System.out.println(eventualSafeNodesBFS(graph));
    }

    public static List<Integer> eventualSafeNodesBFS(int[][] graph) {

        List<List<Integer>> revAdj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++)
            revAdj.add(new ArrayList<>());

        int[] inDegree = new int[graph.length];
        for (int i = 0; i < inDegree.length; i++) {
            for (int v : graph[i]) {
                revAdj.get(v).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }

        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);

            for (int neighbour : revAdj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }


    List<Integer> safeNodes;

    public List<Integer> eventualSafeNodesV2(int[][] graph) {

        List<Integer> res = new AbstractList<Integer>() {

            @Override
            public Integer get(int index) {
                init();
                return safeNodes.get(index);
            }

            @Override
            public int size() {
                init();
                return safeNodes.size();
            }

            private void init() {

                if (safeNodes != null) return;

                int n = graph.length;
                safeNodes = new ArrayList<>();
                int[] inDegree = new int[n];
                List<List<Integer>> reverseAdj = new ArrayList<>();

                for (int i = 0; i < n; i++)
                    reverseAdj.add(safeNodes);

                for (int i = 0; i < n; i++) {
                    for (int neighborNode : graph[i]) {
                        reverseAdj.get(neighborNode).add(i);
                        inDegree[i]++;
                    }
                }

                Queue<Integer> queue = new LinkedList<Integer>();
                for (int i = 0; i < n; i++) {
                    if (inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }

                while (!queue.isEmpty()) {
                    int safeNode = queue.poll();
                    safeNodes.add(safeNode);

                    for (int neighbor : reverseAdj.get(safeNode)) {
                        inDegree[neighbor]--;
                        if (inDegree[neighbor] == 0) {
                            queue.offer(neighbor);
                        }
                    }
                }
                Collections.sort(safeNodes);
            }
        };

        return res;
    }
}
