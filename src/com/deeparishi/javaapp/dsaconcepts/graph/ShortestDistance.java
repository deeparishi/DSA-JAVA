package com.deeparishi.javaapp.dsaconcepts.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/?envType=daily-question&envId=2024-11-27

public class ShortestDistance {

    public static void main(String[] args) {

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        int[] result = new int[queries.length];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < n - 1; i++)
            graph.get(i).add(i + 1);

        for (int i = 0; i < result.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            graph.get(u).add(v);

            result[i] = bfs(graph, n);
        }

        return result;
    }

    private int bfs(List<List<Integer>> graph, int n) {

        boolean[] visited = new boolean[n];
        int level = 0;
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()){
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int polled = queue.poll();

                if(polled == n - 1)
                    return level;

                for (Integer neighbour : graph.get(polled)){
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            level++;
        }

        return -1;
    }


}
