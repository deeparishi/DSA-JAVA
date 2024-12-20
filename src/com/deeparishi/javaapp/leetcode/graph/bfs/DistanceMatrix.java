package com.deeparishi.javaapp.leetcode.graph.bfs;

import com.deeparishi.javaapp.leetcode.graph.utls.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/

public class DistanceMatrix {

    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        System.out.println(Arrays.deepToString(optimizedSolution(mat)));
    }

    public static int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visit = new boolean[n][m];
        int[][] distance = new int[n][m];

        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new Pair(i, j, 0));
                    visit[i][j] = true;
                }
            }
        }

        int[] dRow = new int[]{-1, 0, 1, 0};
        int[] dCol = new int[]{0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int row = queue.peek().row;
            int col = queue.peek().col;
            int steps = queue.peek().time;
            queue.poll();

            distance[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visit[nRow][nCol]) {
                    visit[nRow][nCol] = true;
                    queue.add(new Pair(nRow, nCol, steps + 1));
                }
            }
        }

        return distance;
    }

    public static int[][] optimizedSolution(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Initialize the queue with all 0s and mark 1s as unvisited (-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // Mark as unvisited
                }
            }
        }

        // Direction arrays for moving up, down, left, and right
        int[] dRow = new int[]{-1, 0, 1, 0};
        int[] dCol = new int[]{0, 1, 0, -1};

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            // Traverse all 4 possible directions
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                // Check bounds and ensure the cell is unvisited
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && mat[nRow][nCol] == -1) {
                    mat[nRow][nCol] = mat[row][col] + 1; // Update distance
                    queue.add(new int[]{nRow, nCol});    // Add to queue for further processing
                }
            }
        }

        return mat;
    }
}
