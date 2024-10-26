package com.deeparishi.javaapp.leetcode.string;

import java.util.List;

public class ReverseVowelString {

    public static void main(String[] args) {
        String ans = reverseVowels("LeetCode");
        System.out.println(ans);
    }

    public static String reverseVowels(String s) {

        char[] answer = s.toCharArray();
        List<Character> vowelsCaps = List.of('A', 'E', 'I', 'O', 'U');
        List<Character> vowelsSmall = List.of('a', 'e', 'i', 'o', 'u');

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if ((vowelsCaps.contains(answer[left]) || vowelsSmall.contains(answer[left])) &&
                    (vowelsCaps.contains(answer[right]) || vowelsSmall.contains(answer[right]))) {

                char temp = answer[left];
                answer[left] = answer[right];
                answer[right] = temp;
                left++;
                right--;
            } else if (vowelsCaps.contains(answer[left]) || vowelsSmall.contains(answer[left])) {
                right--;
            } else {
                left++;
            }
        }


        return new String(answer);
    }



}
