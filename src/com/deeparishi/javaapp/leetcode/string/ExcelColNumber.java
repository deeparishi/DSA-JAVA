package com.deeparishi.javaapp.leetcode.string;

// QUE Link -> https://leetcode.com/problems/excel-sheet-column-number


public class ExcelColNumber {

    public static void main(String[] args) {

        int num = titleToNumber("AB");
        System.out.println(num);
    }

    public static int titleToNumber(String columnTitle) {

        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {

            int r = columnTitle.charAt(i) - 'A' + 1;

            result = result * 26 + r;

        }

        return result;
    }
}
