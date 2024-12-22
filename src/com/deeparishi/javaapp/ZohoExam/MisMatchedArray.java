package com.deeparishi.javaapp.ZohoExam;

public class MisMatchedArray {

    public static void main(String[] args) {
        char[] arr1 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
        char[] arr2 = {'a', 'b', 'd', 'e', 'e', 'g', 'g', 'i', 'i'};

        findAndPrintMismatchedElements(arr1, arr2);
    }

    public static void findAndPrintMismatchedElements(char[] arr1, char[] arr2) {
        int minLength = Math.min(arr1.length, arr2.length);

        for (int i = 0; i < minLength; i++) {
            if (arr1[i] != arr2[i]) {
                System.out.print(arr1[i]);
                System.out.print(arr2[i]);
                System.out.print(", ");
            }
        }

        if (arr1.length > arr2.length) {
            for (int i = minLength; i < arr1.length; i++) {
                System.out.print(arr1[i]);
                System.out.print(", ");
            }
        } else {
            for (int i = minLength; i < arr2.length; i++) {
                System.out.print(arr2[i]);
                System.out.print(", ");
            }
        }
    }
}


