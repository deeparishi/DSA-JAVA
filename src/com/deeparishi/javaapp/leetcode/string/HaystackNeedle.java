package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

public class HaystackNeedle {

    public static void main(String[] args) {
        System.out.println(strStrV3("sadbutsad", "sad"));
        System.out.println(strStrV3("hello", "ll"));
        System.out.println(strStrV3("leetcode", "leeto"));
    }

    public static int strStrV1(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;
        return haystack.indexOf(needle);
    }

    public static int strStrV2(String haystack, String needle) {

        if (needle.length() > haystack.length()) return -1;

        int startIdx = -1;
        char needleChar = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {
            char hayStackChar = haystack.charAt(i);
            if (hayStackChar == needleChar) {
                startIdx = i;
                int x = i;
                int y = 0;
                while (x < haystack.length() && y < needle.length()) {
                    if (haystack.charAt(x) == needle.charAt(y)) {
                        x++;
                        y++;
                    } else
                        break;
                    if (y == needle.length()) return startIdx;
                }

                startIdx = -1;
            }
        }

        return startIdx;
    }

    public static int strStrV3(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            char hay = haystack.charAt(i);
            char need = needle.charAt(0);
            if (hay == need && haystack.length() > i + needle.length()) {
                String str = haystack.substring(i, i + needle.length());
                if (str.equals(needle)) return i;
            }
        }

        return -1;
    }
}
