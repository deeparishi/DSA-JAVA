package com.deeparishi.javaapp.ZohoExam;

public class LongestPalindrome {
    public static void main(String[] args) {

        String a = "babad";
        System.out.println(longestPalindrome(a));
        //System.out.println(a.substring(0,2));
    }


    public static String longestPalindrome(String a) {
        int n = a.length();
        if (n == 0) {
            return "";
        }

        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (a.charAt(i) == a.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        // Check for palindromes of length 3 or more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (a.charAt(i) == a.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }

        return a.substring(start, start + maxLen);
    }


}


