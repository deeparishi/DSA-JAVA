package com.deeparishi.javaapp.ZohoExam;

import java.util.ArrayList;
import java.util.List;

public class GapSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int gap = 4;
        System.out.println(gap(arr, gap));
    }

    public static List<Integer> gap(int arr[], int gap) {
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < gap; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j += 3) {
                sum += arr[j];
            }
            a.add(sum);
        }
        return a;
    }
}
