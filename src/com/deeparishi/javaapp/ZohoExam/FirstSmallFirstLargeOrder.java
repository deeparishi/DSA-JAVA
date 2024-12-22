package com.deeparishi.javaapp.ZohoExam;

import java.util.Arrays;

public class FirstSmallFirstLargeOrder {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        //int a = sc.nextInt();
        //int [] arr = new int[a];
        //for (int i=0; i<arr.length; i++){
        //  arr[i] = sc.nextInt();
        //}
        int[] arr = {5, 6, -2, 1, 3, 10};
        orderArray(arr);
    }

    public static void orderArray(int[] arr) {

        Arrays.sort(arr);
        int[] result = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        int i = 0;
        while (left < right) {
            result[i++] = arr[left++];
            result[i++] = arr[right--];
        }
        if (left == right) {
            result[i] = arr[left];
        }

        for (int j = 0; j < result.length; j++) {
            System.out.println(result[j]);
        }
    }
}
