package com.deeparishi.javaapp.ZohoExam;

public class ImplementStrStr {
    public static void main(String[] args) {
        String a = "dpeeparishi";
        String b = "ee";
        //System.out.println(strStr(a,b));


    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1; // Invalid input
        }

        int haystackLen = haystack.length();
        int needleLen = needle.length();

        if (needleLen == 0) {
            return 0; // An empty needle is always found at index 0
        }

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i; // Found the first occurrence of the needle
            }
        }

        return -1; // Needle not found in haystack
    }

}
