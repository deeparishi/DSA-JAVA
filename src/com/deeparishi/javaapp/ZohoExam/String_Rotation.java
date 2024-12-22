package com.deeparishi.javaapp.ZohoExam;

public class String_Rotation {
    public static void main(String[] args) {
        String a = "mypencil";
        String b = "pencilmy";
        System.out.println(isRotation(a, b));
    }

    public static boolean isRotation(String str1, String str2) {
        // Check if the lengths of the two strings are the same and not empty
        if (str1.length() != str2.length() || str1.isEmpty()) {
            return false;
        }

        // Concatenate str1 with itself
        String concatenatedStr = str1 + str1;

        // Check if str2 is a substring of the concatenated string
        return concatenatedStr.contains(str2);
    }
}
