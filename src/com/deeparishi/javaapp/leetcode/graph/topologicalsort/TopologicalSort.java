package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/topological-sort/1

public class TopologicalSort {

    public static void main(String[] args) {

    }

    static ArrayList<Integer> topologicalSortUsingDFS(ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[adj.size()];
        Stack<Integer> res = new Stack<>();

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i])
                dfs(i, visited, res, adj);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!res.isEmpty())
            result.add(res.pop());

        return result;
    }

    private static void dfs(int node, boolean[] visited,
                            Stack<Integer> res, ArrayList<ArrayList<Integer>> adj) {

        visited[node] = true;
        for (Integer neighbour : adj.get(node)) {
            if (!visited[neighbour])
                dfs(neighbour, visited, res, adj);
        }
        res.push(node);
    }

    //Khan's Algorithm for BFS approach
    static int[] topologicalSortUsingBFS(ArrayList<ArrayList<Integer>> adj) {

        int[] inDegree = new int[adj.size()];
        for (ArrayList<Integer> owner : adj) {
            for (Integer neighbour : owner)
                inDegree[neighbour]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < adj.size(); i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }

        int[] topSort = new int[adj.size()];
        int i = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topSort[i++] = node;

            for (Integer neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    queue.add(neighbour);
            }
        }

        return topSort;
    }
}