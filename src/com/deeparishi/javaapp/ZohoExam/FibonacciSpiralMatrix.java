package com.deeparishi.javaapp.ZohoExam;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSpiralMatrix {
    public static void main(String[] args) {


        int a = 4;
        int b = 10;
        int[][] arr = pattern(a, b);
        List<Integer> l = generateFibonacciSpiral(arr);
        print(l, b);

    }

    private static int[][] pattern(int a, int b) {

        int x = 0;
        int y = 1;
        int temp;
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = x;
                temp = x;
                x = temp + y;
                y = temp;

            }

        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(arr[i][j] + " " + " ");
            }
            System.out.println();
        }
        System.out.println(arr.length);
        return arr;
    }

    private static List<Integer> generateFibonacciSpiral(int[][] arr) {
        List<Integer> a = new ArrayList<>();
        if (arr[0].length == 0 && arr.length == 0) {
            return a;
        }
        int cl = 0;
        int rl = 0;
        int cu = arr[0].length - 1;
        int ru = arr.length - 1;

        while (rl <= ru && cl <= cu) {

            for (int i = cl; i <= cu; i++) {
                a.add(arr[rl][i]);
            }
            rl++;

            for (int i = rl; i <= ru; i++) {
                a.add(arr[i][cu]);
            }
            cu--;

            if (cl > cu || rl > ru) {
                break;
            }

            for (int i = cu; i >= cl; i--) {
                a.add(arr[ru][i]);
            }
            ru--;

            for (int i = ru; i >= rl; i--) {
                a.add(arr[i][cl]);
            }
            cl++;
        }

        return a;
    }

    private static void print(List<Integer> l, int b) {
        int count = 1;
        for (Integer i : l) {

            if (count == b + 1) {
                System.out.println();
                count = 1;
            }
            System.out.print(i + " " + " ");
            count++;

        }
    }
}



















