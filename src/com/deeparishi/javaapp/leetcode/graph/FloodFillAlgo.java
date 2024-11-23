package com.deeparishi.javaapp.leetcode.graph;

//https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1?page=1&category=Graph&sortBy=submissions

public class FloodFillAlgo {

    public static void main(String[] args) {

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int val = image[sr][sc];

        if (val == newColor)
            return image;

        int rows = image.length;
        int cols = image[0].length;
        int[][] newImage = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            System.arraycopy(image[i], 0, newImage[i], 0, cols);

        dfs(newImage, val, sr, sc, newColor);

        return newImage;
    }

    private void dfs(int[][] newImage, int val, int sr, int sc, int newColor) {

        if(sr < 0 || sr >= newImage.length || sc < 0 || sc >= newImage[0].length || newImage[sr][sc] != val)
            return;

        newImage[sr][sc] = newColor;

        dfs(newImage, val, sr - 1, sc, newColor);
        dfs(newImage, val, sr + 1, sc, newColor);
        dfs(newImage, val, sr, sc - 1, newColor);
        dfs(newImage, val, sr, sc + 1, newColor);

    }


}
