package com.deeparishi.javaapp.ZohoExam;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(reverseWord("geeks"));
    }

    public static String reverseWord(String str) {
        int len1 = str.length();
        int j = str.length() - 1;
        char arr[] = str.toCharArray();
        char temp;
        for (int i = 0; i < len1 / 2; i++) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        String a = String.valueOf(arr);
        return a;
    }
}
