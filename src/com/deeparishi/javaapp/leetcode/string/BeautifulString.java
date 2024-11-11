package com.deeparishi.javaapp.leetcode.string;

// https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/?envType=daily-question&envId=2024-11-05

public class BeautifulString {

    public static void main(String[] args) {

        System.out.println(minChanges("1001")); // 2 because string converted into 1100 in two steps
        System.out.println(minChanges("10")); // 1 because 10 into 11 or 00 in one step

    }

    static int minChanges(String s) {
        int count  = 0;

        for(int i = 0; i < s.length() - 1; i += 2){
            if(s.charAt(i) != s.charAt(i+1))
                count++;
        }

        return count;
    }
}
