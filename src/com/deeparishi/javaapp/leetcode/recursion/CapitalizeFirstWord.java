package com.deeparishi.javaapp.leetcode.recursion;

public class CapitalizeFirstWord {

    public static void main(String[] args) {

        System.out.println(capitalizeWords("i love java"));
    }

    static String capitalizeWords(String str) {

        if (str == null || str.isEmpty()) {
            return str;
        }
        int spaceIndex = str.indexOf(' ');

        if (spaceIndex == -1) {
            return Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        String firstWord = str.substring(0, spaceIndex);
        String restOfString = str.substring(spaceIndex + 1);

        return Character.toUpperCase(firstWord.charAt(0)) + firstWord.substring(1) + " " + capitalizeWords(restOfString);
    }
}
