package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/zigzag-conversion/

public class ZigZag {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            for (int j = row; j < s.length(); j += cycleLen) {
                result.append(s.charAt(j)); // upward move
                int secondCharIndex = j + cycleLen - 2 * row;
                if (row != 0 && row != numRows - 1 && secondCharIndex < s.length()) {  // downward + middle move
                    result.append(s.charAt(secondCharIndex));
                }
            }
        }

        return result.toString();
    }

}