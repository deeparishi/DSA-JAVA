package com.deeparishi.javaapp.leetcode.prefixsum;

// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

public class MaxScoreAfterSplitting {

    public static void main(String[] args) {
        System.out.println(maxScore("00"));
    }

    // Brute Force Approach
    public static int maxScore(String s) {

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= s.length() - 1; i++) {
            int maxZero = count(s.substring(0, i), '0');
            int maxCount = count(s.substring(i), '1');
            max = Math.max(max, maxZero + maxCount);
        }

        return max;
    }

    private static int count(String s, char c) {
        int sum = 0;

        for (char ch : s.toCharArray()){
            if(c == ch) sum++;
        }

        return sum;
    }

    public static int maxScoreOptimal(String s) {

        int totalOnes = 0;
        int leftZeros = 0;
        int max = Integer.MIN_VALUE;

        for (char ch : s.toCharArray())
            if ('1' == ch) totalOnes++;


        for (int i = 0; i <= s.length() - 1; i++) {
            if ('0' == s.charAt(i)) leftZeros++;

            int rightOnes = totalOnes - (i + 1 - leftZeros);
            max = Math.max(max, leftZeros + rightOnes);
        }

        return max;
    }
}
