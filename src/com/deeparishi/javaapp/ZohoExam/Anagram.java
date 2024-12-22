package com.deeparishi.javaapp.ZohoExam;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {


        String s1 = "silent";
        String s2 = "listen";

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}