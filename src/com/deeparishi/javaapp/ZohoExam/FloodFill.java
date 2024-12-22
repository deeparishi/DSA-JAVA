package com.deeparishi.javaapp.ZohoExam;

public class FloodFill {
    public static void main(String args[]) {
        int[][] image1 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 0, 1}
        };
        int sr1 = 0, sc1 = 1, newColor1 = 2;
        int[][] result1 = floodFill(image1, sr1, sc1, newColor1);
        for (int i = 0; i < image1.length; i++) {
            for (int j = 0; j < image1.length; j++) {
                System.out.print(image1[i][j]);
            }
            System.out.println();
        }
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];

        // Check if the new color is the same as the original color
        if (originalColor == newColor) {
            return image;
        }

        dfs(image, sr, sc, originalColor, newColor);
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int originalColor, int newColor) {
        // Check if the current position is out of bounds or not the original color
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] != originalColor) {
            return;
        }

        // Change the color of the current pixel
        image[x][y] = newColor;

        // Recursively visit adjacent pixels
        dfs(image, x + 1, y, originalColor, newColor); // Down
        dfs(image, x - 1, y, originalColor, newColor); // Up
        dfs(image, x, y + 1, originalColor, newColor); // Right
        dfs(image, x, y - 1, originalColor, newColor); // Left
    }
}
