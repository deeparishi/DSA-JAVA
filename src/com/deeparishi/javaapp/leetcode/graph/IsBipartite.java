package com.deeparishi.javaapp.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/is-graph-bipartite/
public class IsBipartite {

    public static void main(String[] args) {

    }

    public static boolean isBipartiteUsingBFS(int[][] graph) {

        int row = graph.length;
        int[] colors = new int[row];

        for (int i = 0; i < row; i++) {
            if (colors[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                colors[i] = 1;
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    for (int neighbour : graph[curr]) {
                        if (colors[neighbour] == 0) {
                            colors[neighbour] = -colors[curr];
                            queue.add(neighbour);
                        } else if (colors[neighbour] == colors[curr]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
