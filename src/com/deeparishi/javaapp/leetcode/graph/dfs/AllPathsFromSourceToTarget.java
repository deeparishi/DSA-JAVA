package com.deeparishi.javaapp.leetcode.graph.dfs;

// https://leetcode.com/problems/all-paths-from-source-to-target/description/?envType=problem-list-v2&envId=graph

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public static void main(String[] args) {

    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        paths.add(0);
        dfs(graph, 0, paths, result);
        return result;
    }

    private void dfs(int[][] graph, int curr, List<Integer> paths,
                     List<List<Integer>> result) {

        if (curr == graph.length - 1) {
            result.add(new ArrayList<>(paths));
            return;
        }
        for (int neighbour : graph[curr]) {
            paths.add(neighbour);
            dfs(graph, neighbour, paths, result);
            paths.removeLast();
        }
    }
}
