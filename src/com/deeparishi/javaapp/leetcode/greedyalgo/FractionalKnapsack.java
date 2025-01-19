package com.deeparishi.javaapp.leetcode.greedyalgo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

public class FractionalKnapsack {

    public static void main(String[] args) {

        int[][] items = {
                {100, 20},
                {60, 10},
                {100, 50},
                {200, 50}
        };

        System.out.println(fractionalKnapsack(items, 90));
    }

    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {

        int[][] items = new int[val.size()][2];

        for (int i = 0; i < val.size(); i++)
            items[i] = new int[]{val.get(i), wt.get(i)};

        Arrays.sort(items, (a, b) -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
        double total = 0;

        for (int[] item : items) {
            double value = (double) item[0];
            double weight = (double) item[1];

            if (capacity >= weight) {
                total += value;
                capacity -= weight;
            } else {
                double each = value / weight;
                total += each * capacity;
                break;
            }
        }

        return total;
    }

    public static double fractionalKnapsack(int[][] items, int weight) {

        Comparator<int[]> comparator1 = new Comparator<>() {
            @Override
            public int compare(int[] a, int[] b) {
                double d1 = (double) a[0] / a[1];
                double d2 = (double) b[0] / b[1];
                return Double.compare(d2, d1);
            }
        };

        Comparator<int[]> comparator2 = (a, b) -> {
            double d1 = (double) a[0] / a[1];
            double d2 = (double) b[0] / b[1];
            return Double.compare(d2, d1);
        };

        Arrays.sort(items, (a, b)  -> Double.compare((double) b[0] / b[1], (double) a[0] / a[1]));
//        Arrays.sort(items, comparator2);


        double total = 0;

        for (int[] item : items) {
            double val = item[0];
            double wt = item[1];

            if (weight >= wt) {
                total += val;
                weight -= wt;
            } else {
                double each = val / wt;
                total += each * weight;
                break;
            }
        }


        return total;
    }
}
