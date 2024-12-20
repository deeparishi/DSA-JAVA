package com.deeparishi.javaapp.leetcode.graph.shortestpath.dijikistra;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/description/

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0}
        };

        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        if (grid[0][0] == 1 || grid[row - 1][col - 1] == 1)
            return -1;

        Queue<IPath> queue = new LinkedList<>();
        queue.add(new IPath(0, 0, 1));

        int[] dRow = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dCol = {-1, 0, 1, 1, 1, 0, -1, -1};

        while (!queue.isEmpty()) {

            IPath path = queue.poll();
            int r = path.row;
            int c = path.col;
            int dist = path.distance;

            if (r == row - 1 && c == col - 1)
                return dist;

            for (int i = 0; i < 8; i++) {

                int nr = r + dRow[i];
                int nc = c + dCol[i];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0) {
                    queue.add(new IPath(nr, nc, dist + 1));
                    grid[nr][nc] = 1;
                }

            }
        }
        return -1;
    }
}

class IPath{

    int row;

    int col;

    int distance;

    public IPath(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}