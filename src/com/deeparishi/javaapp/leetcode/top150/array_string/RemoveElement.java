package com.deeparishi.javaapp.leetcode.top150.array_string;

// https://leetcode.com/problems/remove-element/

public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElementSimple(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    // 0,1,2,2,3,0,4,2 val = 2
    // Output: 5, arr = [0,1,4,0,3,_,_,_]
    public static int removeElement(int[] arr, int val) {
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            int slow = arr[i];
            int fast = arr[j];

            if (slow != val && fast != val) {
                i++;
                j++;
                continue;
            }
            if (fast != val) {
                arr[i] = arr[j];
                arr[j] = val;
                i++;
            }

            j++;
        }

        return i;
    }

    public static int removeElementSimple(int[] arr, int val) {

        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] != val)
                arr[slow++] = arr[fast];
        }

        return slow;
    }

}