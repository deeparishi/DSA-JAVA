package com.deeparishi.javaapp.leetcode.graph.bfs;

import com.deeparishi.javaapp.leetcode.graph.utls.Pair;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/rotten-oranges2536/1?page=1&category=Graph&sortBy=submissions

public class RottenOranges {

    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        Queue<Pair> rottenQueue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int freshOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) {
                    rottenQueue.add(new Pair(i, j, 0));
                    visited[i][j] = true;
                } else
                    visited[i][j] = false;

                if (mat[i][j] == 1)
                    freshOranges++;
            }
        }

        int time = 0;
        int[] rowCheck = {-1, 0, 1, 0};
        int[] colCheck = {-0, 1, 0, -1};


        while (!rottenQueue.isEmpty()) {

            int row = rottenQueue.peek().row;
            int col = rottenQueue.peek().col;
            int tm = rottenQueue.peek().time;
            time = Math.max(time, tm);
            rottenQueue.poll();

            for (int i = 0; i < 4; i++) {
                int newRow = row + rowCheck[i];
                int newCol = col + colCheck[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m &&
                        !visited[newRow][newCol] && mat[newRow][newCol] == 1) {
                    rottenQueue.add(new Pair(newRow, newCol, tm + 1));
                    visited[newRow][newCol] = true;
                    freshOranges--;
                }
            }
        }

        if(freshOranges > 0)
            return  -1;

        return time;

    }
}


