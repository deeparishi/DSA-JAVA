package com.deeparishi.javaapp.leetcode.graph.dfs;

//https://leetcode.com/problems/number-of-provinces/description/?envType=problem-list-v2&envId=graph
public class Provinces {

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {

        int row = isConnected.length;
        boolean[] isVisited = new boolean[row];
        int connectionCount = 0;

        for (int i = 0; i < row; i++) {
                if(!isVisited[i]){
                    connectionCount++;
                    dfs(i, isConnected, isVisited);
                }
            
        }

        return connectionCount;
    }

    private static void dfs(int i, int[][] isConnected, boolean[] isVisited) {
        isVisited[i] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !isVisited[j]) {
                dfs(j, isConnected, isVisited);
            }
        }
    }

}
