package com.deeparishi.javaapp.selfpractice.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 3, 4, 7, 2, 8, 6, 9, 1};
        bucketSort(arr);

    }

    static void bucketSort(int[] arr) {

        int[] newArray = new int[arr.length];
        int bucketCount = (int) Math.ceil(Math.sqrt(arr.length));
        List<Integer>[] buckets = new ArrayList[bucketCount];

        int maxValue = Integer.MIN_VALUE;

        for (Integer i : arr) {
            if (i > maxValue)
                maxValue = i;
        }

        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int val : arr) {
            int bucketNum = (int) Math.ceil(((float) val * (float) bucketCount) / (float) maxValue);
            buckets[bucketNum - 1].add(val);
        }

        System.out.println(" Before Sorting... ");
        printBucket(buckets);

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        System.out.println(" After Sorting the bucket... ");
        printBucket(buckets);

        System.out.println();
        ascendingOrder(buckets, newArray);
        display(newArray);
        System.out.println();
        descendingOrder(buckets, newArray);
        display(newArray);

//        return newArray;

    }

    private static void descendingOrder(List<Integer>[] buckets, int[] newArray) {
        int index = 0;
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = buckets[i].size() - 1; j >= 0; j--) {
                newArray[index++] = buckets[i].get(j);
            }
        }
    }

    private static void ascendingOrder(List<Integer>[] buckets, int[] newArray) {
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                newArray[index++] = buckets[i].get(j);
            }
        }
    }

    static void printBucket(List<Integer>[] buckets) {

        for (int i = 0; i < buckets.length; i++) {
            System.out.println("Bucket " + i + ":");
            for (int j = 0; j < buckets[i].size(); j++) {
                System.out.print(buckets[i].get(j) + " ");
            }
        }
    }

    private static void display(int[] newArr) {
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }


}