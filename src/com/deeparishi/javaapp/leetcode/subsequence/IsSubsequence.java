package com.deeparishi.javaapp.leetcode.subsequence;

// https://leetcode.com/problems/is-subsequence/

public class IsSubsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty()) return true;
        if(t.isEmpty()) return false;

        int left = 0;

        for(int right = 0; right < t.length(); right++) {
            char leftCh = s.charAt(left);
            char rightCh = t.charAt(right);

            if(leftCh == rightCh) {
                left++;
                if(left == s.length())
                    return true;
            }
        }

        return false;

    }

}
