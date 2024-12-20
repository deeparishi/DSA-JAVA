package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.com/problems/path-with-minimum-effort/

public class PathWithMinimumEffort {

    public static void main(String[] args) {

    }

    public static int minimumEffortPath(int[][] heights) {

        int row = heights.length;
        int col = heights[0].length;

        int[][] effort = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        Queue<Tuple> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        queue.add(new Tuple(0, 0, 0));

        int[] dRow = new int[]{-1, 0, 1, 0};
        int[] dCol = new int[]{0, 1, 0, -1};

        while (!queue.isEmpty()) {

            Tuple tuple = queue.poll();
            int r = tuple.row;
            int c = tuple.col;
            int diff = tuple.distance;

            if (r == row - 1 && c == col - 1)
                return diff;

            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col) {
                    int newEffort = Math.max(Math.abs(heights[r][c] - heights[nr][nc]), diff);
                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        queue.add(new Tuple(nr, nc, newEffort));
                    }
                }
            }
        }

        return 0;
    }
}

class Tuple{

    int row;

    int col;

    int distance;

    public Tuple(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}