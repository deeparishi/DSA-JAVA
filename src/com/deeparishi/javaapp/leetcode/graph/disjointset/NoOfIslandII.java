package com.deeparishi.javaapp.leetcode.graph.disjointset;

import com.deeparishi.javaapp.leetcode.graph.disjointset.utils.DisjointSet;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/number-of-islands/1
public class NoOfIslandII {

    public static void main(String[] args) {

    }

    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {

        DisjointSet ds = new DisjointSet(rows * cols);
        boolean[][] visited = new boolean[rows][cols];
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        List<Integer> res = new ArrayList<>();
        int count = 0;

        for (int[] op : operators) {
            int row = op[0];
            int col = op[1];

            if (visited[row][col]) {
                res.add(count);
                continue;
            }

            visited[row][col] = true;
            count++;

            for (int j = 0; j < 4; j++) {
                int adjRow = row + dr[j];
                int adjCol = col + dc[j];

                if (isValid(rows, cols, adjRow, adjCol) && visited[adjRow][adjCol]) {
                    int nodeNo = row * cols + col;
                    int adjNo = adjRow * cols + adjCol;

                    if (ds.find(nodeNo) != ds.find(adjNo)) {
                        count--;
                        ds.union(nodeNo, adjNo);
                    }
                }
            }

            res.add(count);
        }

        return res;
    }

    private boolean isValid(int rows, int cols, int adjRow, int adjCol) {
        return adjRow >= 0 && adjRow < rows && adjCol >= 0 && adjCol < cols;
    }
}
