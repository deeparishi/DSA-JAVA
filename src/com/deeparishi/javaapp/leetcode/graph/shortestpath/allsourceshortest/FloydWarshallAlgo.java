package com.deeparishi.javaapp.leetcode.graph.shortestpath.allsourceshortest;

public class FloydWarshallAlgo {

    public static void main(String[] args) {
        int[][] vertices = new int[][]{
                {0, 2, -1, -1},
                {1, 0, 3, -1},
                {-1, -1, 0, -1},
                {3, 5, 4, 0}
        };

        floydWarshall(vertices);
    }

    public static void floydWarshall(int[][] vertices) {

        int size = vertices.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (vertices[i][j] == -1)
                    vertices[i][j] = (int) 1e9;
                if (i == j)
                    vertices[j][j] = 0;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    if (vertices[i][k] != (int) 1e9 && vertices[k][j] != (int) 1e9) {
                        vertices[i][j] = Math.min(vertices[i][j], vertices[i][k] + vertices[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (vertices[i][j] == (int) 1e9)
                    vertices[i][j] = -1;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Printing Distance list for node " + i + " : ");
            for (int j = 0; j < size; j++) {
                System.out.print(vertices[i][j] + " ");
            }
            System.out.println();
        }
    }
}
