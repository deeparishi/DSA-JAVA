package com.deeparishi.javaapp.ZohoExam;

public class Spiral2 {

    public static void main(String[] args) {
        int n = 7; // Change this value to adjust the size of the spiral
        printSpiral(n);
    }

    public static void printSpiral(int n) {
        int[][] spiral = new int[n][n];
        int num = n;

        int row = 0;
        int col = 0;

        while (num > 0) {
            // Move right
            for (int i = 0; i < num; i++) {
                spiral[row][col] = num;
                col++;
            }
            col--;
            row++;

            // Move down
            for (int i = 0; i < num - 1; i++) {
                spiral[row][col] = num;
                row++;
            }

            // Move left
            for (int i = 0; i < num - 1; i++) {
                spiral[row][col] = num;
                col--;
            }

            // Move up
            for (int i = 0; i < num - 2; i++) {
                spiral[row][col] = num;
                row--;
            }

            num -= 2;
            col++;
        }

        // Print the spiral
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(spiral[i][j]);
            }
            System.out.println();
        }
    }
}

